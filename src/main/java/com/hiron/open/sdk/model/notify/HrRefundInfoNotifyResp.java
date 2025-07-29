package com.hiron.open.sdk.model.notify;


import lombok.Data;

import java.util.List;

/**
 * 发起订单退款通知
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrRefundInfoNotifyResp {
    /**
     * 退款单号（最大长度：32）示例：03ba4e720241020184116
     */
    private String refundCode;

    /**
     * 订单号（最大长度：32）示例：221222175718001
     */
    private Long orderId;

    /**
     * 原交易支付单号（最大长度：100）示例：4200002205202406069566302886
     */
    private String transactionNo;

    /**
     * 退款金额，单位：分（最大长度：4）示例：500
     */
    private Integer refundFee;

    /**
     * 退款时间戳（最大长度：14）示例：1608797457029
     */
    private Long refundTimestamp;

    /**
     * 退款商品列表
     */
    private List<HrGoodsInfoBaseParams> refundGoods;

}
