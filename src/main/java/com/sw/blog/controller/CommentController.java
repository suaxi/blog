package com.sw.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sw.blog.constant.Status;
import com.sw.blog.constant.StringConstant;
import com.sw.blog.pojo.Comment;
import com.sw.blog.pojo.ResponseResult;
import com.sw.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Wang Hao
 * @date 2021/11/17 14:26
 */
@RestController
@RequestMapping("/comment")
@Api(tags = "评论接口")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("新增评论")
    @PostMapping
    public ResponseResult<Comment> createComment(@Valid Comment comment) {
        if (commentService.createComment(comment)) {
            return new ResponseResult<>(SUCCESS, "新增成功！");
        }
        return new ResponseResult<>(FAIL, "新增失败！");
    }

    @ApiOperation("修改评论")
    @PutMapping
    public ResponseResult<Comment> updateComment(@Valid Comment comment) {
        if (commentService.updateComment(comment)) {
            return new ResponseResult<>(SUCCESS, "修改成功！");
        }
        return new ResponseResult<>(FAIL, "修改失败！");
    }

    @ApiOperation("删除评论")
    @ApiImplicitParam(name = "commentIds", value = "一个或多个评论ID", required = true, paramType = "path", dataType = "String")
    @DeleteMapping("/{commentIds}")
    public ResponseResult<String[]> deleteCommentByIds(@NotNull @PathVariable("commentIds") String commentIds) {
        if (commentService.deleteCommentByIds(commentIds.split(StringConstant.COMMA))) {
            return new ResponseResult<>(SUCCESS, "删除成功！");
        }
        return new ResponseResult<>(FAIL, "删除失败！");
    }

    @ApiOperation("评论审核")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "评论ID", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "状态", required = true, paramType = "path", dataType = "String")
    })
    @PostMapping("/reviewComment/{id}/{status}")
    public ResponseResult<Boolean> reviewComment(@NotNull @PathVariable("id") Integer id, @NotNull @PathVariable("status") String status) {
        Comment comment = new Comment();
        comment.setCommentId(id);
        comment.setStatus(Status.parseOf(status));
        return new ResponseResult<>(SUCCESS, commentService.updateComment(comment));
    }


    @ApiOperation("查询评论（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, paramType = "path", dataType = "Integer")
    })
    @GetMapping("/findCommentPage/{status}/{pageNum}/{pageSize}")
    public ResponseResult<Page<Comment>> findCommentPage(@NotNull @PathVariable("status") String status,
                                                         @NotNull @PathVariable("pageNum") Integer pageNum,
                                                         @NotNull @PathVariable("pageSize") Integer pageSize) {
        return new ResponseResult<>(SUCCESS, commentService.findCommentPage(null, null, Status.parseOf(status).getCode(), pageNum, pageSize));
    }

    @ApiOperation("根据文章ID查询（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, paramType = "path", dataType = "Integer")
    })
    @GetMapping("/findCommentPageByArticleId/{articleId}/{pageNum}/{pageSize}")
    public ResponseResult<Page<Comment>> findCommentPageByArticleId(@NotNull @PathVariable("articleId") Integer articleId,
                                                                    @NotNull @PathVariable("pageNum") Integer pageNum,
                                                                    @NotNull @PathVariable("pageSize") Integer pageSize) {
        return new ResponseResult<>(SUCCESS, commentService.findCommentPage(articleId, null, Status.PASS.getCode(), pageNum, pageSize));
    }

    @ApiOperation("根据用户名查询（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, paramType = "path", dataType = "Integer")
    })
    @GetMapping("/findCommentPageByArticleId/{username}/{pageNum}/{pageSize}")
    public ResponseResult<Page<Comment>> findCommentPageByUsername(@NotNull @PathVariable("username") String username,
                                                                   @NotNull @PathVariable("pageNum") Integer pageNum,
                                                                   @NotNull @PathVariable("pageSize") Integer pageSize) {
        return new ResponseResult<>(SUCCESS, commentService.findCommentPage(null, username, Status.PASS.getCode(), pageNum, pageSize));
    }

}
