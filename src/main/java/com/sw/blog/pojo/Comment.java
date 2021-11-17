package com.sw.blog.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.sw.blog.constant.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author suaxi
 * @description 评论表
 * @date 2021/11/17 14:05
 */
@Data
@ApiModel("评论表")
@TableName(value = "t_comment")
public class Comment implements Serializable {

    @ApiModelProperty(value = "COMMENT_ID")
    @TableId(value = "COMMENT_ID", type = IdType.AUTO)
    private Integer commentId;

    @ApiModelProperty(value = "父级ID")
    @TableField(value = "PARENT_Id")
    private Integer parentId;

    @ApiModelProperty(value = "文章ID")
    @TableField(value = "ARTICLE_ID")
    private Integer articleId;

    @ApiModelProperty(value = "用户名")
    @TableField(value = "USERNAME")
    private String username;

    @ApiModelProperty(value = "评论内容")
    @TableField(value = "CONTENT")
    private String content;

    @ApiModelProperty(value = "状态")
    @TableField(value = "STATUS")
    private Status status;

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
