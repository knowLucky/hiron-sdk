package com.hiron.open.sdk.service.order.vo;


import lombok.Data;

import java.util.List;

/**
 * 订单客诉请求参数
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrOrderComplaintApplyReqVO {
    
    /**
     * 简单购平台返回的订单号
     */
    private Long orderId;
    
    /**
     * 交易单号
     */
    private String transactionNo;
    
    /**
     * 客诉时间
     */
    private String complaintTimestamp;
    
    /**
     * 客诉原因
     * 反馈原因(1:扣错款 2:商品识别错误 3:不是我买的 4:关不了锁 5:质量有问题 10:其他 )
     */
    private Integer reasonCode;
    
    /**
     * 客诉描述
     */
    private String description;
    
    /**
     * 客诉反馈图片
     */
    private List<String> feedbackImgs;
    
    /**
     * 联系人手机号
     */
    private String contactPhone;
    
}
