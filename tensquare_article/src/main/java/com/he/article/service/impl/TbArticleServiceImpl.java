package com.he.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.Utils.IdWorker;
import com.he.article.dao.TbArticleDao;
import com.he.article.entity.TbArticle;
import com.he.article.service.TbArticleService;
import com.he.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Transactional
public class TbArticleServiceImpl extends ServiceImpl<TbArticleDao, TbArticle> implements TbArticleService{
    @Autowired
    TbArticleDao tbArticleDao;
    @Autowired
    IdWorker idWorker;
    @Override
    public boolean insertIDworker(TbArticle tbArticle) {
        String l = idWorker.nextId()+"";
        tbArticle.setId(l);
        Integer insert = tbArticleDao.insert(tbArticle);
        if (insert<=0){

            return false;
        }
        return true;
    }

    @Override
    public PageResult<TbArticle> selectqueryPage(Integer page, Integer size, Map<String,Object> map) {
        QueryWrapper<TbArticle> wrapper = new QueryWrapper<>();
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            wrapper.eq(map.get(s)!=null,s,map.get(s));
        }
        Page<TbArticle> tbArticlePage = tbArticleDao.selectPage(new Page<>(page, size), wrapper);
        PageResult<TbArticle> pageResult = new PageResult<>();
        long total = tbArticlePage.getTotal();
        List<TbArticle> records = tbArticlePage.getRecords();
        pageResult.setTotal(total);
        pageResult.setRows(records);
        return pageResult;
    }

    @Override
    public List<TbArticle> selectquery(Map<String, Object> map) {
        QueryWrapper<TbArticle> wrapper = new QueryWrapper<>();

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
        wrapper.eq(map.get(key)!=null,key,map.get(key));
        }
        List<TbArticle> list = tbArticleDao.selectList(wrapper);
        return list;
    }

    @Override
    public boolean updateByIdLike(String articleId) {
        TbArticle tbArticle = tbArticleDao.selectById(articleId);
        Integer thumbup = tbArticle.getThumbup();
        int newthumbup= thumbup+1;
        tbArticle.setThumbup(newthumbup);
        tbArticle.setId(articleId);
        int i = tbArticleDao.updateById(tbArticle);
        if (i<=0){
            return false;
        }
        return true;
    }
}
