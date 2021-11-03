package com.sw.blog.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 文章表
 * @Author suaxi
 * @Date 2021/11/03 16:00
 */
@Data
@ApiModel("文章表")
@TableName(value = "t_article")
public class Article implements Serializable {

    @ApiModelProperty(value = "ARTICLE_ID")
    @TableId(value = "ARTICLE_ID", type = IdType.AUTO)
    private Integer articleId;

    @ApiModelProperty(value = "分类ID")
    @TableField(value = "CATEGORY_ID")
    private Integer categoryId;

    @ApiModelProperty(value = "作者ID")
    @TableField(value = "AUTHOR_ID")
    private Integer authorId;

    @ApiModelProperty(value = "标题")
    @TableField(value = "TITLE")
    private String title;

    @ApiModelProperty(value = "内容")
    @TableField(value = "TEXT")
    private String text;

    @ApiModelProperty(value = "标签")
    @TableField(value = "TAG")
    private String tag;

    @ApiModelProperty(value = "浏览量")
    @TableField(value = "VIEWS")
    private Integer views;

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
