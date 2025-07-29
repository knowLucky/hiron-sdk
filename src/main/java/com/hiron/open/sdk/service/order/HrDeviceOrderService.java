package com.hiron.open.sdk.service.order;


import com.hiron.open.sdk.annotation.HrApi;
import com.hiron.open.sdk.model.vo.PageResponse;
import com.hiron.open.sdk.service.order.dto.HrComplaintDetailRespDTO;
import com.hiron.open.sdk.service.order.dto.HrOrderResultRespDTO;
import com.hiron.open.sdk.service.order.vo.*;

/**
 * 简单购 设备管理
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
@HrApi("/facade/coop/order")
public interface HrDeviceOrderService {
    
    /**
     * 订单⽀付成功通知
     * 
     * @param vo 通知参数
     * @return 通知结果
     */
    @HrApi(value = "/payResult", method = "POST")
    HrOrderResultRespDTO orderPayResult(HrOrderPayResultReqVO vo);
    
    
    /**
     * 订单退款结果通知
     * 
     * @param vo 订单参数
     * @return 订单结果
     */
    @HrApi(value = "/refundResult", method = "POST")
    HrOrderResultRespDTO orderRefundResult(HrOrderRefundResultReqVO vo);
    
    
    /**
     * 订单补缴结果通知
     * 
     * @param vo 订单参数
     * @return 订单结果
     */
    @HrApi(value = "/extraResult", method = "POST")
    HrOrderResultRespDTO orderExtraResult(HrOrderExtraResultReqVO vo);
    
    
    /**
     * 订单投诉申请结果通知
     * 
     * @param vo 订单参数
     * @return 订单结果
     */
    @HrApi(value = "/complaint/apply", method = "POST")
    HrOrderResultRespDTO complaintApply(HrOrderComplaintApplyReqVO vo);
    
    
    /**
     * 订单投诉详情结果查询
     * 
     * @param vo 订单参数
     * @return 订单结果
     */
    @HrApi(value = "/complaint/detail", method = "GET")
    PageResponse<HrComplaintDetailRespDTO> queryComplaintDetail(HrOrderComplaintDetailReqVO vo);
    
    /**
     * 订单投诉协商
     * 
     * @param vo 订单参数
     * @return 订单结果
     */
    @HrApi(value = "/complaint/negotiate", method = "POST")
    HrOrderResultRespDTO complaintNegotiate(HrOrderComplaintNegotiateReqVO vo);
    
}
