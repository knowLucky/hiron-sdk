package com.hiron.open.sdk.model.notify;


import lombok.Data;

/**
 * 售后订单处理通知
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrSaleOrderNotifyResp {
    /**
     * 售后单号
     */
    private String complaintCode;

    /**
     * 订单号
     */
    private Long orderId;

    /**
     * 投诉类型（最大长度：4）
     */
    private Integer complaintsType;

    /**
     * 投诉状态（最大长度：4）
     * <p> 
     * 反馈原因(1:扣错款 2:商品识别错误 3:不是我买的 4:关不了
     * 锁 5:质量有问题 10:其他 )
     * 
     */
    private Integer complaintStatus;

    /**
     * 处理时间时间戳（最大长度：10）
     * <p> 
     * 11 待处理 21 处理中 31 已处理
     * 
     */
    private Long handledTimestamp;

    /**
     * 投诉单关闭时间戳（最大长度：10）
     */
    private Long closeTimeTimestamp;

    /**
     * 投诉回复
     */
    private String reply;

    /**
     * 是否全额退款
     */
    private Boolean complaintFullrefunded;

    /**
     * 操作人
     */
    private String operator;

}
