package com.hiron.open.sdk.service.order.vo;


import lombok.Data;

/**
 * 订单支付结果请求参数
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrOrderExtraResultReqVO extends HrOrderPayBaseParams{
    
    /**
     * 补缴单号
     */
    private String extraCode;
}
