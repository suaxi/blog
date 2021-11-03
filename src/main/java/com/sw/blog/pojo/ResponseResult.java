package com.sw.blog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description 返回响应实体
 * @author suaxi
 * @date 2021/10/29 14:44
 */
@Data
@ApiModel("返回响应实体")
public class ResponseResult<T> {

    @ApiModelProperty(value = "返回状态码", notes = "200:成功")
    private Integer state;

    @ApiModelProperty(value = "描述信息")
    private String message;

    @ApiModelProperty(value = "响应数据")
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public ResponseResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }
}
