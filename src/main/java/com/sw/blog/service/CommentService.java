package com.sw.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sw.blog.pojo.Comment;

import java.util.List;

/**
 * @author Wang Hao
 * @date 2021/11/17 14:09
 */
public interface CommentService {

    /**
     * 查询评论列表
     * @return
     */
    List<Comment> findCommentList();

    /**
     * 新增
     * @param comment
     * @return
     */
    boolean createComment(Comment comment);

    /**
     * 修改
     * @param comment
     * @return
     */
    boolean updateComment(Comment comment);

    /**
     * 删除
     * @param commentIds
     * @return
     */
    boolean deleteCommentByIds(String[] commentIds);

    /**
     * 分页查询
     * @param articleId
     * @param username
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Comment> findCommentPage(Integer articleId, String username, String status, Integer pageNum, Integer pageSize);

}
