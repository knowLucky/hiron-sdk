package com.hiron.open.sdk.core;

import com.hiron.open.sdk.model.vo.ApiResponse;
import com.hiron.open.sdk.model.constant.HrConstant;
import lombok.Getter;

/**
 * 建议购接口异常类
 * 
 * @author Luckymi
 */
public class HrBusinessException extends RuntimeException {
    @Getter
    private ApiResponse<?> apiResponse;
    public HrBusinessException(String message) {
        this(message,null);
    }
    public HrBusinessException(String message, Throwable cause) {
        super(message, cause,false,false);
        this.apiResponse = new ApiResponse<>();
        apiResponse.setStatus("-1");
        apiResponse.setMessage("系统异常");
        apiResponse.setOk(HrConstant.FALSE);
    }
}
