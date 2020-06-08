package com.he.article.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.article.entity.TbArticle;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章(TbArticle)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 13:21:56
 */
@Mapper
public interface TbArticleDao extends BaseMapper<TbArticle> {

}