package com.he.article.controller;


import com.he.article.entity.TbArticle;
import com.he.article.service.TbArticleService;
import com.he.entity.R;
import com.he.entity.PageResult;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    TbArticleService tbArticleService;
    /**
     * 查询所有文章列表
     * @return
     */
    @GetMapping("/")
    public R findAll(){
        List<TbArticle> list = tbArticleService.list(null);
        return R.OK().setData(list);
    }

    /**
     * 插入一个文章
     * @return
     */
    @PostMapping("/")
    public R insert(@RequestBody TbArticle tbArticle){

        boolean b = tbArticleService.insertIDworker(tbArticle);
        if (!b){
            return R.error();
        }
        return R.OK();
    }

    /**
     * 根据id删除文章
     * @param @PathVariable
     * @return
     */
    @DeleteMapping("/{articleId}")
    public R delectById(@PathVariable("articleId") String articleId){

        boolean b = tbArticleService.removeById(articleId);
        if (!b){
            return R.error();
        }
        return R.OK();
    }

    /**
     * 根据文章id查询文章
     * @param srticleId
     * @return
     */
    @GetMapping("/{srticleId}")
    public R selectById(@PathVariable("srticleId") String srticleId){
        TbArticle tbArticle = tbArticleService.getById(srticleId);
        return R.OK().setData(tbArticle);
    }

    /**
     * 根据条件分页查询
     * @param page
     * @param size
     * @param map
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public R pageselectAll(@PathVariable("page") Integer page,
                                    @PathVariable("size") Integer size,
                                    @RequestBody Map<String,Object> map){
        PageResult<TbArticle> pageResult = tbArticleService.selectqueryPage(page,size,map);
        return R.OK().setData(pageResult);

    }

    /**
     * 条件查询
     * @param map
     * @return
     */
    @PostMapping("/search")
    public R queryFandAll(@RequestBody Map<String,Object> map){
        List<TbArticle> list = tbArticleService.selectquery(map);
        return R.OK().setData(list);

    }

    /**
     * /article/thumbup/{articleId}
     * 点赞
     * Parameters
     * @param
     * @return
     */
    @PutMapping("/thumbup/{articleId}")
    public R updataById(@PathVariable("articleId") String articleId){
        boolean b = tbArticleService.updateByIdLike(articleId);
        if (!b){
            return R.error();
        }
        return R.OK();
    }

}
