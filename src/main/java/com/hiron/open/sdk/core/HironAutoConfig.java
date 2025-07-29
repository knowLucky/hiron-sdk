package com.hiron.open.sdk.core;


import com.hiron.open.sdk.core.okhttp.HrOkHttpClient;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author Luckymi
 * @since 2025/6/19
 */
@AutoConfiguration
@ConditionalOnMissingBean(HrApiProxyFactory.class)
@EnableConfigurationProperties(HironVendingProperties.class)
public class HironAutoConfig {

    
    /**
     * 创建 ApiProxyFactory Bean
     *
     * @param properties 配置属性
     * @return ApiProxyFactory
     */
    @Bean
    @ConditionalOnMissingBean
    public HrApiProxyFactory spApiProxyFactory(HironVendingProperties properties) {
        return new HrApiProxyFactory(new HrOkHttpClient(new OkHttpClient(), properties));
    }
}
