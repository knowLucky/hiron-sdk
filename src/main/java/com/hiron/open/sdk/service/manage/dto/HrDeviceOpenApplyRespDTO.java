package com.hiron.open.sdk.service.manage.dto;


import lombok.Data;

/**
 * 设备开门 返回参数
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
@Data
public class HrDeviceOpenApplyRespDTO {
    
    /**
     * 订单ID
     * <p> 
     * 此订单号用于接受 {@code 订单，开门}结果回调使用
     */
    private Long orderId;
}
