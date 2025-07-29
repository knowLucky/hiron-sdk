package com.hiron.open.sdk.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.annotation.JSONField;
import com.alibaba.fastjson2.annotation.JSONType;
import com.hiron.open.sdk.core.HironVendingProperties;
import lombok.Data;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 签名生成生成工具类
 * 
 * @author Luckymi
 * @since 2025/6/19
 */
public class SignGenerator {
    
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    /**
     * AES加密
     * @param content 待加密内容
     * @param key 密钥(16/24/32字节)
     * @return 加密后的Base64编码字符串
     */
    public static String encrypt(String content, String key) {
        try {
            // 创建密钥对象
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);

            // 创建密码器并初始化
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // 返回Base64编码的加密结果
            return Base64.getEncoder().encodeToString(cipher.doFinal(content.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("AES加密失败", e);
        }
    }

    /**
     * AES解密
     * @param content 待解密内容(Base64编码)
     * @param key 密钥(16/24/32字节)
     * @return 解密后的原始字符串
     */
    public static String decrypt(String content, String key) {
        try {
            // 创建密钥对象
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);

            // 创建密码器并初始化
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // 执行解密
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(content));

            // 返回解密结果
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("AES解密失败", e);
        }
    }

    /**
     * 获取请求签名 Authorization
     * @param properties 配置信息
     * @return 签名
     */
    public static String getSign(HironVendingProperties properties) {
        // 商户编码和密钥
        Token token = new Token();
        token.setMerchantCode(properties.getMerchantCode());
        token.setTimestamp(System.currentTimeMillis());
        // AES算法加密
        String encryption = SignGenerator.encrypt(JSON.toJSONString(token), properties.getSecretKey());
        token.setNonceStr(encryption);
        
        return Base64.getEncoder().encodeToString(JSON.toJSONString(token).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 校验签名
     * @param sign 签名
     * @param properties 配置信息
     * @return 是否通过
     */
    public static boolean checkSign(String sign, HironVendingProperties properties) {
        // Base64 解码
        byte[] decode = Base64.getDecoder().decode(sign);
        String token = new String(decode, StandardCharsets.UTF_8);

        Token jsonTokenByBase64 = JSON.parseObject(token, Token.class);
        // AES 解密
        String encrypt = SignGenerator
                .decrypt(jsonTokenByBase64.getNonceStr(), properties.getSecretKey());
        Token jsonTokenByAes = JSON.parseObject(encrypt, Token.class);
        
        return properties.getMerchantCode().equals(jsonTokenByAes.getMerchantCode());
    }

    /**
     * 订单token实体类，用于生成和传输加密信息。
     * 包含商户编码、时间戳和随机字符串。
     */
    @Data
    @JSONType(orders = {"merchant_code", "nonce_str", "timestamp"})
    public static class Token {
        @JSONField(name = "merchant_code")
        private String merchantCode;
        private Long timestamp;
        @JSONField(name = "nonce_str")
        private String nonceStr;

        public Token() {}
    }
}

