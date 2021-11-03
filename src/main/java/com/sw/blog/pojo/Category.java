package com.sw.blog.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 用户表
 * @author suaxi
 * @date 2021/11/03 16:00
 */
@Data
@ApiModel("分类表")
@TableName(value = "t_category")
public class Category implements Serializable {

    @ApiModelProperty(value = "CATEGORY_ID")
    @TableId(value = "CATEGORY_ID", type = IdType.AUTO)
    private Integer categoryId;

    @ApiModelProperty(value = "父级ID")
    @TableField(value = "PARENT_Id")
    private Integer parentId;

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
