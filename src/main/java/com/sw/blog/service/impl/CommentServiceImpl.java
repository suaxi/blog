package com.sw.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.blog.constant.Status;
import com.sw.blog.mapper.CommentMapper;
import com.sw.blog.pojo.Comment;
import com.sw.blog.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Wang Hao
 * @date 2021/11/17 14:15
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public List<Comment> findCommentList() {
        return this.list();
    }

    @Override
    public boolean createComment(Comment comment) {
        comment.setStatus(Status.PENDING_REVIEW);
        return save(comment);
    }

    @Override
    public boolean updateComment(Comment comment) {
        comment.setStatus(Status.PENDING_REVIEW);
        return updateById(comment);
    }

    @Override
    public boolean deleteCommentByIds(String[] commentIds) {
        return removeByIds(Arrays.asList(commentIds));
    }

    @Override
    public boolean reviewComment(Integer commentId, String status) {
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setStatus(Status.parseOf(status));
        return updateById(comment);
    }

    @Override
    public Page<Comment> findCommentPage(Integer articleId, String username, String status, Integer pageNum, Integer pageSize) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(String.valueOf(articleId)) && articleId != null) {
            queryWrapper.lambda().eq(Comment::getArticleId, articleId);
        }
        if (StringUtils.isNotBlank(username) && username != null) {
            queryWrapper.lambda().like(Comment::getUsername, username);
        }
        if (StringUtils.isNotBlank(status)) {
            queryWrapper.lambda().eq(Comment::getStatus, status);
        }
        Page<Comment> page = new Page<>(pageNum, pageSize);
        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
