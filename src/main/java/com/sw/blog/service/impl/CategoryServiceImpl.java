package com.sw.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.blog.mapper.CategoryMapper;
import com.sw.blog.pojo.Category;
import com.sw.blog.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @author Wang Hao
 * @date 2021/11/3 16:45
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    private final static Integer TOP_NODE_ID = 0;

    @Override
    public List<Category> findCategoryList() {
        return this.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createCategory(Category category) {
        if (category.getParentId() == null) {
            category.setParentId(TOP_NODE_ID);
        }
        return this.save(category);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCategory(Category category) {
        if (category.getParentId() == null) {
            category.setParentId(TOP_NODE_ID);
        }
        return this.updateById(category);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteCategoryByIds(String[] categoryIds) {
        return this.removeByIds(Arrays.asList(categoryIds));
    }
}
