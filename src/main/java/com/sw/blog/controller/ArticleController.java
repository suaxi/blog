package com.sw.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sw.blog.constant.StringConstant;
import com.sw.blog.pojo.Article;
import com.sw.blog.pojo.ResponseResult;
import com.sw.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @description 文章接口
 * @author Wang Hao
 * @date 2021/11/3 17:02
 */
@RestController
@RequestMapping("/article")
@Api(tags = "文章接口")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("新增文章信息")
    @PostMapping
    public ResponseResult<Article> createArticle(@Valid Article article) {
        if (articleService.createArticle(article)) {
            return new ResponseResult<>(SUCCESS, "新增成功！");
        }
        return new ResponseResult<>(FAIL, "新增失败！");
    }

    @ApiOperation("修改文章信息")
    @PutMapping
    public ResponseResult<Article> updateArticle(@Valid Article article) {
        if (articleService.updateArticle(article)) {
            return new ResponseResult<>(SUCCESS, "修改成功！");
        }
        return new ResponseResult<>(FAIL, "修改失败！");
    }

    @ApiOperation("删除文章信息")
    @ApiImplicitParam(name = "articleIds", value = "一个或多个文章ID", required = true, paramType = "path", dataType = "String")
    @DeleteMapping("/{articleIds}")
    public ResponseResult<String[]> deleteArticleByIds(@NotNull @PathVariable("articleIds") String articleIds) {
        if (articleService.deleteArticleByIds(articleIds.split(StringConstant.COMMA))) {
            return new ResponseResult<>(SUCCESS, "删除成功！");
        }
        return new ResponseResult<>(FAIL, "删除失败！");
    }

    @ApiOperation("查询文章（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, paramType = "path", dataType = "Integer")
    })
    @GetMapping("/findArticlePage/{pageNum}/{pageSize}")
    public ResponseResult<Page<Article>> findArticlePage(@NotNull @PathVariable("pageNum") Integer pageNum,
                                                         @NotNull @PathVariable("pageSize") Integer pageSize) {
        return new ResponseResult<>(SUCCESS, articleService.findArticlePage(null, null, pageNum, pageSize));
    }

    @ApiOperation("根据标题查询（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, paramType = "path", dataType = "Integer")
    })
    @GetMapping("/findArticlePageByTitle/{title}/{pageNum}/{pageSize}")
    public ResponseResult<Page<Article>> findArticlePageByTitle(@NotNull @PathVariable("title") String title,
                                                                @NotNull @PathVariable("pageNum") Integer pageNum,
                                                                @NotNull @PathVariable("pageSize") Integer pageSize) {
        return new ResponseResult<>(SUCCESS, articleService.findArticlePage(title, null, pageNum, pageSize));
    }

    @ApiOperation("根据标签查询（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tag", value = "文章标签", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, paramType = "path", dataType = "Integer")
    })
    @GetMapping("/findArticlePageByTag/{tag}/{pageNum}/{pageSize}")
    public ResponseResult<Page<Article>> findArticlePageByTag(@NotNull @PathVariable("tag") String tag,
                                                              @NotNull @PathVariable("pageNum") Integer pageNum,
                                                              @NotNull @PathVariable("pageSize") Integer pageSize) {
        return new ResponseResult<>(SUCCESS, articleService.findArticlePage(null, tag, pageNum, pageSize));
    }
}
