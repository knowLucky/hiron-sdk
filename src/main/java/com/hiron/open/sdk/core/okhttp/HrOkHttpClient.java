package com.hiron.open.sdk.core.okhttp;

import com.hiron.open.sdk.core.HironVendingProperties;
import com.hiron.open.sdk.core.HrBusinessException;
import com.hiron.open.sdk.model.constant.HrConstant;
import com.hiron.open.sdk.utils.SignGenerator;
import okhttp3.*;
import okhttp3.internal.http.HttpMethod;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * A simple OkHttp wrapper for GET/POST/PUT requests.
 * @author Luckymi
 * @since 2025/6/19
 */
public class HrOkHttpClient {

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private final OkHttpClient client;
    private final HironVendingProperties properties;

    public HrOkHttpClient(OkHttpClient client, HironVendingProperties properties) {
        this.client = client;
        this.properties = properties;
    }
    
    public String doRequest(String path,Object params, HttpMethod method) {
        Request request;
        HttpUrl url = buildUrl(path, method == HttpMethod.GET || method == HttpMethod.PUT ? params : null);
        RequestBody body = null;

        if (method != HttpMethod.GET) {
            body = buildRequestBody(params);
        }

        request = buildRequest(url, body, method);
        return executeRequest(request);
    }

    /** ------------------------- Private Methods ------------------------ **/

    private HttpUrl buildUrl(String path, Object queryParams) {
        HttpUrl.Builder builder = Objects.requireNonNull(HttpUrl.parse(properties.getBaseUrl()))
                .newBuilder(Objects.requireNonNull(path));

        if (queryParams != null && builder != null) {
            Map<String, String> map = convertToMap(queryParams);
            map.forEach(builder::addQueryParameter);
        }
        return builder.build();
    }

    private Request buildRequest(HttpUrl url, RequestBody body, HttpMethod method) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .header(HttpHeaders.AUTHORIZATION, SignGenerator.getSign(properties))
                .addHeader(HrConstant.CLIENT, HrConstant.COOP)
                .addHeader(HrConstant.MERCHANT_CODE, properties.getMerchantCode());

        switch (method) {
            case GET:
                builder.get();
                break;
            case POST:
                builder.post(body);
                break;
            case PUT:
                builder.put(body);
                break;
            default:
                throw new HrBusinessException("Unsupported HTTP method: " + method);
        }
        return builder.build();
    }

    private String executeRequest(Request request) {
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new HrBusinessException("请求失败: " + response.code() + ", " + response.message());
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                throw new HrBusinessException("空响应体: URL=" + request.url());
            }
            return responseBody.string();
        } catch (IOException e) {
            throw new HrBusinessException("接口调用异常: URL=" + request.url(), e);
        }
    }

    private RequestBody buildRequestBody(Object bodyObj) {
        try {
            String json = Jackson.mapper().writeValueAsString(bodyObj);
            return RequestBody.create(json, JSON);
        } catch (JsonProcessingException e) {
            throw new HrBusinessException("请求体序列化失败", e);
        }
    }

    /**
     * 将对象转换为 Map<String, String>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> convertToMap(Object obj) {
        return Jackson.convertValue(obj, new TypeReference<Map<String, String>>() {});
    }
}
