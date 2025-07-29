package com.hiron.open.sdk.model.notify;


import lombok.Data;

/**
 * 开关⻔结果异步通知
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrOpenDoorNotifyResp {
    
    /**
     * 请求订单号
     */
    private String requestId;
    
    /**
     * 简易购订单号
     */
    private String orderCode;
    
    /**
     * 用户标识
     */
    private String userCode;
    
    /**
     * 门状态  rade_open:购物开⻔   trade_close:购物关⻔
     */
    private String action;
    
    /**
     * 状态码  对应枚举DeviceOperationStatus
     */
    private Integer status;
}
