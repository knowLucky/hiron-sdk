package com.hiron.open.sdk.service.manage.vo;


import lombok.Data;

/**
 * 设备开门 请求参数
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
@Data
public class HrDeviceOpenResultReqVO {
    
    /**
     * 开⻔请求ID，需要保证唯⼀ (订单号）
     */
    private String requestId;
}
