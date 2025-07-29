package com.hiron.open.sdk.service.order.dto;


import lombok.Data;

/**
 * 订单返回参数
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrOrderResultRespDTO {
    
    /**
     * 投诉单号 售后订单号
     */
    private String complaintCode;
}
