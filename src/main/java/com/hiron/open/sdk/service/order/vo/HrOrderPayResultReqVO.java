package com.hiron.open.sdk.service.order.vo;


import lombok.Data;

/**
 * 订单支付结果请求参数
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrOrderPayResultReqVO extends HrOrderPayBaseParams{
    
    /**
     * 订单ID  简单购平台返回的订单号
     */
    private Long orderId;
}
