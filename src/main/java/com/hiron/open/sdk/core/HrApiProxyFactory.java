package com.hiron.open.sdk.core;


import com.hiron.open.sdk.core.okhttp.HrOkHttpClient;

import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * api 工厂
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
public class HrApiProxyFactory {
    
    private final HrOkHttpClient httpClient;
    private final ConcurrentMap<Class<?>, Object> apiCache = new ConcurrentHashMap<>();
    
    public HrApiProxyFactory(HrOkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @SuppressWarnings("unchecked")
    public <T> T getApi(Class<T> tClass) {
        if (!tClass.isInterface()) {
            throw new HrBusinessException("tClass must be an interface");
        }
        return (T) apiCache.computeIfAbsent(tClass, key -> {
            ApiHandler<T> apiHandler = new ApiHandler<>(tClass, httpClient);
            return Proxy.newProxyInstance(
                    tClass.getClassLoader(), 
                    new Class[]{tClass}, 
                    apiHandler
            );
        });
    }


}
