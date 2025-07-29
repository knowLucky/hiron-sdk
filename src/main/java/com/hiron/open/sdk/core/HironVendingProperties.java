package com.hiron.open.sdk.core;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 简单购 售货柜配置
 * 
 * @author Luckymi
 * @since 2025/6/19
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "gruul.hiron.vending")
public class HironVendingProperties {
    
    /**
     * 商户唯⼀标示
     */
    String merchantCode = "xinnongpinsell";
    
    /**
     * 商户密钥
     */
    String secretKey = "gz3dv3phbdkxbugq";
    
    /**
     * 接口地址
     */
    String baseUrl = "https://open.ainfinit.com";
    
    /**
     * 微信支付分回调地址
     */
    String wxPayScoreNotifyUrl = "http://www.yujianxiangwei.com";
}
