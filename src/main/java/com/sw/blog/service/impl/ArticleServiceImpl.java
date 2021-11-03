package com.sw.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.blog.mapper.ArticleMapper;
import com.sw.blog.pojo.Article;
import com.sw.blog.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Wang Hao
 * @Date 2021/11/3 16:48
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public List<Article> findArticleList() {
        return this.list();
    }

    @Override
    public boolean createArticle(Article article) {
        return false;
    }

    @Override
    public boolean updateArticle(Article article) {
        return false;
    }

    @Override
    public boolean deleteArticleByIds(String[] articleIds) {
        return false;
    }

    @Override
    public Page<Article> findArticlePage(String title, String tag, int pageNum, int pageSize) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(title)) {
            queryWrapper.lambda().like(Article::getTitle, title);
        }
        if (StringUtils.isNotBlank(tag)) {
            queryWrapper.lambda().like(Article::getTag, tag);
        }
        Page<Article> page = new Page<>(pageNum, pageSize);
        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
