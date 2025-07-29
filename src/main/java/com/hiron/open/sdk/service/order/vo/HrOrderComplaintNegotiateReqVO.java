package com.hiron.open.sdk.service.order.vo;


import lombok.Data;

import java.util.List;

/**
 * 售后订单客户协商 请求参数
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrOrderComplaintNegotiateReqVO {
    
    /**
     * 售后单号
     */
    private String complaintCode;
    
    /**
     * 协商时间
     */
    private Long negotiateTimestamp;
    
    /**
     * 协商内容
     */
    private String negotiateDetail;
    
    /**
     * 协商图片
     */
    private List<String> imageList;
}
