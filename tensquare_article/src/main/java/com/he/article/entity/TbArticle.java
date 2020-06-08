package com.he.article.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章(TbArticle)实体类
 *
 * @author makejava
 * @since 2020-06-08 13:21:55
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TbArticle implements Serializable {
    private static final long serialVersionUID = 934582269588741916L;
    /**
    * ID
    */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
    * 专栏ID
    */
    private String columnid;
    /**
    * 用户ID
    */
    private String userid;
    /**
    * 标题
    */
    private String title;
    /**
    * 文章正文
    */
    private String content;
    /**
    * 文章封面
    */
    private String image;
    /**
    * 发表日期
    */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;
    /**
    * 修改日期
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;
    /**
    * 是否公开
    */
    private String ispublic;
    /**
    * 是否置顶
    */
    private String istop;
    /**
    * 浏览量
    */
    private Integer visits;
    /**
    * 点赞数
    */
    private Integer thumbup;
    /**
    * 评论数
    */
    private Integer comment;
    /**
    * 审核状态
    */
    private String state;
    /**
    * 所属频道
    */
    private String channelid;
    /**
    * URL
    */
    private String url;
    /**
    * 类型
    */
    private String type;



}