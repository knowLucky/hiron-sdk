package com.hiron.open.sdk.service.order.vo;


import lombok.Data;

/**
 * 订单支付结果  基础参数
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrOrderPayBaseParams {
    
    /**
     * 支付时间
     */
    private Long paidTime;
    
    /**
     * 支付金额 （分）
     */
    private Integer paidFee;
    
    /**
     * 交易单号
     */
    private String transactionNo;
}
