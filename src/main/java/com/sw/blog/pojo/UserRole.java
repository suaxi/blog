package com.sw.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 用户角色关系表
 * @Author suaxi
 * @Date 2021/10/29 13:59
 */
@Data
@ApiModel("用户角色关系表")
@TableName(value = "t_user_role")
public class UserRole implements Serializable {

    @ApiModelProperty(value = "用户ID")
    @TableField(value = "USER_ID")
    private long userId;

    @ApiModelProperty(value = "角色ID")
    @TableField(value = "ROLE_ID")
    private long roleId;

}
