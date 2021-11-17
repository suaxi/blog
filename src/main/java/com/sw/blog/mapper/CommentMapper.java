package com.sw.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sw.blog.pojo.Comment;
import org.springframework.stereotype.Repository;

/**
 * @author Wang Hao
 * @date 2021/11/17 14:08
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
}
