package com.sw.blog.controller;

import com.sw.blog.constant.StringConstant;
import com.sw.blog.pojo.Category;
import com.sw.blog.pojo.ResponseResult;
import com.sw.blog.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description 分类接口
 * @author Wang Hao
 * @date 2021/11/3 16:55
 */
@RestController
@RequestMapping("/category")
@Api(tags = "分类接口")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("查询分类列表")
    @GetMapping("/findCategoryList")
    public ResponseResult<List<Category>> findCategoryList() {
        return new ResponseResult<>(SUCCESS, categoryService.findCategoryList());
    }

    @ApiOperation("新增分类信息")
    @PostMapping
    public ResponseResult<Category> createCategory(@Valid Category category) {
        if (categoryService.createCategory(category)) {
            return new ResponseResult<>(SUCCESS, "新增成功！");
        }
        return new ResponseResult<>(FAIL, "新增失败！");
    }

    @ApiOperation("修改分类信息")
    @PutMapping
    public ResponseResult<Category> updateCategory(@Valid Category category) {
        if (categoryService.updateCategory(category)) {
            return new ResponseResult<>(SUCCESS, "修改成功！");
        }
        return new ResponseResult<>(FAIL, "修改失败！");
    }

    @ApiOperation("删除分类信息")
    @ApiImplicitParam(name = "categoryIds", value = "一个或多个分类ID", required = true, paramType = "path", dataType = "String")
    @DeleteMapping("/{categoryIds}")
    public ResponseResult<Integer> deleteCategoryByIds(@NotNull @PathVariable("categoryIds") String categoryIds) {
        if (categoryService.deleteCategoryByIds(categoryIds.split(StringConstant.COMMA))) {
            return new ResponseResult<>(SUCCESS, "删除成功！");
        }
        return new ResponseResult<>(FAIL, "删除失败！");
    }

}
