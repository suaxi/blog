package com.sw.blog.service;

import com.sw.blog.pojo.Category;

import java.util.List;

/**
 * @Description
 * @Author Wang Hao
 * @Date 2021/11/3 16:39
 */
public interface CategoryService {

    /**
     * 查询分类列表
     * @return
     */
    List<Category> findCategoryList();

    /**
     * 新增
     * @param category
     * @return
     */
    boolean createCategory(Category category);

    /**
     * 修改
     * @param category
     * @return
     */
    boolean updateCategory(Category category);

    /**
     * 删除
     * @param categoryIds
     * @return
     */
    boolean deleteCategoryByIds(String[] categoryIds);
}
