package com.hiron.open.sdk.service.order.dto;


import lombok.Data;

import java.util.List;

/**
 * 客诉订单查询返回参数
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrComplaintDetailRespDTO {
    
    /**
     * 售后单号
     */
    private String complaintCode;
    
    /**
     * 订单ID
     */
    private Long orderId;
    
    /**
     * 客诉原因 反馈原因(1:扣错款 2:商品识别错误 3:不是我买的 4:关不了锁 5:质量有问题 10:其他 )
     */
    private Integer reasonCode;
    
    /**
     * 客诉描述
     */
    private String description;
    
    /**
     * 客诉图片列表
     */
    private List<String> imgUrlList;
    
    /**
     * 客诉反馈时间
     */
    private Long feedbackTimestamp;
    
    /**
     * 客诉处理状态 11 待处理 21 处理中 31 已处理
     */
    private Integer handledState;
    
    /**
     * 客诉处理时间
     */
    private Long handledTimestamp;
    
    /**
     * 客诉处理人
     */
    private String handledUser;
    
    /**
     * 客诉处理图片列表
     */
    private List<String> handleImg;
    
    /**
     * 客诉处理信息
     */
    private String handleMsg;
    
    /**
     * 客诉处理回复记录
     */
    private List<ReplyLog> replyLogs;
    
    /**
     * 客诉处理回复记录
     */
    @Data
    static class ReplyLog {
        /**
         * 回复ID
         */
        private String logId;
        
        /**
         * 回复时间
         */
        private Long logTimestamp;
        
        /**
         * 回复类型 1 客户留⾔ 2 商户回复
         */
        private Integer logType;
        
        /**
         * 回复内容
         */
        private String logDetail;
        
        /**
         * 回复图片列表
         */
        private List<String> imageList;
    }
}
