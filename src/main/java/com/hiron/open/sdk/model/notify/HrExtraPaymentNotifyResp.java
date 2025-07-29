package com.hiron.open.sdk.model.notify;


import lombok.Data;

import java.util.List;

/**
 * 发起订单补缴回调
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrExtraPaymentNotifyResp {
    /**
     * 订单号（最大长度：32）
     */
    private Long orderId;

    /**
     * 补缴单号（最大长度：32）
     */
    private String extraCode;

    /**
     * 补缴金额，单位：分（最大长度：4）
     */
    private Integer extraFee;

    /**
     * 发起补缴时间戳（最大长度：14）
     */
    private Long extraStartTimestamp;

    /**
     * 补缴商品列表
     */
    private List<HrGoodsInfoBaseParams> extraGoods;

}
