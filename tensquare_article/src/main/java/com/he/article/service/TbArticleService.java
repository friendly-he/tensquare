package com.he.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.article.entity.TbArticle;
import com.he.entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 文章(TbArticle)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 13:21:57
 */
public interface TbArticleService extends IService<TbArticle> {


    boolean insertIDworker(TbArticle tbArticle);

    PageResult<TbArticle> selectqueryPage(Integer page, Integer size, Map<String,Object> map);

    List<TbArticle> selectquery(Map<String, Object> map);

    boolean updateByIdLike(String articleId);
}