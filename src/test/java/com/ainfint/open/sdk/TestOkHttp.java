package com.ainfint.open.sdk;


import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.util.JacksonFeature;
import com.hiron.open.sdk.core.HironVendingProperties;
import com.hiron.open.sdk.utils.SignGenerator;
import com.medusa.gruul.common.jackson.Jackson;
import okhttp3.*;

import java.io.IOException;

/**
 * @author Luckymi
 * @since 2025/6/19
 */
public class TestOkHttp {
    private final OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {
        new TestOkHttp().run(new HironVendingProperties());
    }
    
    public void run(HironVendingProperties properties) throws Exception {

        // HttpUrl url = HttpUrl.parse(properties.getBaseUrl() + "/facade/coop/place/page")
        // HttpUrl url = HttpUrl.parse(properties.getBaseUrl() + "/facade/coop/device/page")
        HttpUrl url = HttpUrl.parse(properties.getBaseUrl() + "/facade/coop/operation/open/apply")
                .newBuilder()
                .addQueryParameter("requestId", "SP" + IdUtil.getSnowflakeNextId())
                .addQueryParameter("scanCode", "JZ118901")
                .addQueryParameter("userCode", "Luckymi")
                .addQueryParameter("localTimestamp", String.valueOf(System.currentTimeMillis()))
                .build();
        // SpDeviceOpenApplyReqVO spDeviceOpenApplyReqVO = new SpDeviceOpenApplyReqVO();
        // spDeviceOpenApplyReqVO.setRequestId("SP" + IdUtil.getSnowflakeNextId());
        // spDeviceOpenApplyReqVO.setScanCode("JZ118901");
        // spDeviceOpenApplyReqVO.setUserCode("small cat");
        // spDeviceOpenApplyReqVO.setLocalTimestamp(System.currentTimeMillis());
        RequestBody body = RequestBody.create(JSON.toJSONString(""), MediaType.parse("application/json; charset=utf-8"));
        
        Request request = new Request.Builder()
                // .url(properties.getBaseUrl() + "/facade/coop/dept/list")
                // .url(properties.getBaseUrl() + "/facade/coop/placeTag/list")
                .url(url)
                .header("Authorization", SignGenerator.getSign(properties))
                .addHeader("Client", "coop")
                .addHeader("MerchantCode", properties.getMerchantCode())
                .put(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println("Server: " + response.header("Server"));
            System.out.println("Date: " + response.header("Date"));
            System.out.println("Vary: " + response.headers());
            System.out.println("Body: " + response.body().string());
        }
    }
}
