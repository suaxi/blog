package com.sw.blog.pojo;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 角色表
 * @author suaxi
 * @date 2021/10/29 13:59
 */
@Data
@ApiModel("角色表")
@TableName(value = "t_role")
public class Role implements Serializable {

    @ApiModelProperty(value = "角色ID")
    @TableId(value = "ROLE_ID", type = IdType.AUTO)
    private Integer roleId;

    @ApiModelProperty(value = "角色")
    @TableField(value = "ROLENAME")
    private String rolename;

    @ApiModelProperty(value = "描述")
    @TableField(value = "DESCRIPTION")
    private String description;

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
