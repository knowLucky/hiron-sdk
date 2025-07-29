package com.hiron.open.sdk.core;


import com.alibaba.fastjson2.JSON;
import com.hiron.open.sdk.annotation.HrApi;
import com.hiron.open.sdk.core.okhttp.HrOkHttpClient;
import com.hiron.open.sdk.model.enums.DeviceOperationStatus;
import com.hiron.open.sdk.model.vo.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Luckymi
 * @since 2025/6/20
 */
@Slf4j
public class ApiHandler<T> implements InvocationHandler {

    private final HrApi hrApi;
    private final HrOkHttpClient httpClient;
    private final ConcurrentMap<Type, Type> paramTypes = new ConcurrentHashMap<>();
    private final Class<T> tClass;

    public ApiHandler(Class<T> tClass, HrOkHttpClient httpClient) {
        this.httpClient = httpClient;
        this.tClass = tClass;
        this.hrApi = tClass.getAnnotation(HrApi.class);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 不拦截 Object 默认方法
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, args);
        }
        Object arg = args[0];
        log.debug("req -> {}.{} {}", tClass.getSimpleName(), method.getName(), JSON.toJSONString(arg));
        HrApi annotation = method.getAnnotation(HrApi.class);
        
        // 发起请求
        String body = httpClient.doRequest(buildUrl(annotation), arg, HttpMethod.resolve(annotation.method()));
        log.debug("rep <- {}",body);
        
        // 类型匹配转换
        Type type = method.getGenericReturnType();
        Type paramType = paramTypes.computeIfAbsent(type, key -> buildApiResponseType(type));
        
        ApiResponse<?> response = Jackson.mapper()
                .readValue(body, Jackson.mapper().getTypeFactory().constructType(paramType));
        if (method.getReturnType() == ApiResponse.class) {
            return response;
        }
        DeviceOperationStatus status = DeviceOperationStatus.getByCode(Integer.parseInt(response.getStatus()));
        if (status.isSuccess()) {
            return Objects.isNull(response.getData()) ? response.getResult() : response.getData();
        } else {
            log.error("接口异常{}  {}",status.getCode(), status.getDescription());
            throw new HrBusinessException(response.getMessage());
        }
    }

    /**
     * 构建返回类型
     *
     * @param type 返回类型
     * @return JavaType
     */
    private Type buildApiResponseType(Type type) {
        return Jackson.mapper().getTypeFactory().constructParametricType(ApiResponse.class,
                Jackson.mapper().getTypeFactory().constructType(type)
        );
    }
    
    /**
     * 构建请求路径
     *
     * @param spanApi 注解
     * @return 请求路径
     */
    private String buildUrl(HrApi spanApi) {
        StringBuilder urlBuilder = new StringBuilder();
        if (hrApi != null) {
            urlBuilder.append(hrApi.value());
        }
        if (spanApi != null) {
            urlBuilder.append(spanApi.value());
        }
        return urlBuilder.toString();
    }
}
