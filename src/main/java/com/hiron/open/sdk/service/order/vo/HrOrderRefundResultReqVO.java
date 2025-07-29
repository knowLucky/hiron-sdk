package com.hiron.open.sdk.service.order.vo;


import lombok.Data;

/**
 * 订单退款结果请求参数
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrOrderRefundResultReqVO {
    
    /**
     * 退款码
     */
    private String refundCode;
    
    /**
     * 退款时间
     */
    private Long refundTime;
    
    /**
     * 退款金额
     */
    private Long refundFee;
    
    /**
     * 交易单号
     */
    private String transactionNo;
}
