package com.sw.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sw.blog.pojo.Article;

import java.util.List;

/**
 * @description
 * @author Wang Hao
 * @date 2021/11/3 16:39
 */
public interface ArticleService {

    /**
     * 查询文章列表
     * @return
     */
    List<Article> findArticleList();

    /**
     * 新增
     * @param article
     * @return
     */
    boolean createArticle(Article article);

    /**
     * 修改
     * @param article
     * @return
     */
    boolean updateArticle(Article article);

    /**
     * 删除
     * @param articleIds
     * @return
     */
    boolean deleteArticleByIds(String[] articleIds);

    /**
     * 分页查询
     * @param title
     * @param tag
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Article> findArticlePage(String title, String tag, Integer pageNum, Integer pageSize);
}
