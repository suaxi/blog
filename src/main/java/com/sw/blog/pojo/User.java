package com.sw.blog.pojo;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 用户表
 * @Author suaxi
 * @Date 2021/10/29 13:59
 */
@Data
@ApiModel("用户表")
@TableName(value = "t_user")
public class User implements Serializable {

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    @TableField(value = "USERNAME")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField(value = "PASSWORD")
    private String password;

    @ApiModelProperty(value = "角色ID")
    @TableField(value = "ROLE_ID")
    private Integer roleId;

    @ApiModelProperty(value = "描述")
    @TableField(value = "DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "状态")
    @TableField(value = "STATUS")
    private String status;

    @ApiModelProperty(value = "最后登录时间")
    @TableField(value = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间", hidden = true)
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    @TableField("IS_DELETE")
    @ApiModelProperty(value = "逻辑删除", hidden = true)
    private String isDelete;

}
