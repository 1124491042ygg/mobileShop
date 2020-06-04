package com.mobile.mall.utils.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class BaseResponse implements Serializable {
    @ApiModelProperty(value = "错误码")
    private int errno;
    @ApiModelProperty(value = "错误信息")
    private String errmsg;
    @ApiModelProperty(value = "返回数据")
    private Object data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}