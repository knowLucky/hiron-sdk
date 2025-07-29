package com.hiron.open.sdk.service.manage;


import com.hiron.open.sdk.annotation.HrApi;
import com.hiron.open.sdk.model.vo.PageResponse;
import com.hiron.open.sdk.service.manage.dto.HrDeviceGoodsListRespDTO;
import com.hiron.open.sdk.service.manage.dto.HrDeviceListRespDTO;
import com.hiron.open.sdk.service.manage.dto.HrDeviceOpenApplyRespDTO;
import com.hiron.open.sdk.service.manage.dto.HrOpenDoorResultRespDTO;
import com.hiron.open.sdk.service.manage.vo.HrDeviceGoodsListReqVO;
import com.hiron.open.sdk.service.manage.vo.HrDeviceListReqVO;
import com.hiron.open.sdk.service.manage.vo.HrDeviceOpenApplyReqVO;
import com.hiron.open.sdk.service.manage.vo.HrDeviceOpenResultReqVO;

import java.util.List;

/**
 * 简单购 设备管理
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
@HrApi("/facade/coop")
public interface HrDeviceManageService {
    
    /**
     * 设备列表
     * 
     * @param vo 请求参数
     * @return 设备列表
     */
    @HrApi(value = "/device/page", method = "GET")
    PageResponse<HrDeviceListRespDTO> list(HrDeviceListReqVO vo);
    
    /**
     * 设备商品列表
     * 
     * @param vo 请求参数
     * @return 设备商品列表
     */
    @HrApi(value = "/inventory/goodsList", method = "GET")
    List<HrDeviceGoodsListRespDTO> goodsList(HrDeviceGoodsListReqVO vo);
    
    
    /**
     * 设备开门
     * <p> 
     * 说明：这里开门请求使用的是 PUT 请求方式，但是请求路径上也要带上body中的参数！！！ {@code 就很奇怪！！}
     * 
     * @param vo 请求参数
     * @return 设备开门结果
     */
    @HrApi(value = "/operation/open/apply", method = "PUT")
    HrDeviceOpenApplyRespDTO openDoor(HrDeviceOpenApplyReqVO vo);
    
    /**
     * 设备开门结果
     * 
     * @param vo 请求id
     * @return 设备开门结果
     */
    @HrApi(value = "/operation/open/result", method = "GET")
    HrOpenDoorResultRespDTO openDoorResult(HrDeviceOpenResultReqVO vo);
}
