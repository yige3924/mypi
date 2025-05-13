package com.xieyun.paicoding.service.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章表
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("article")
public class ArticleDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 文章类型：1-博文，2-问答
     */
    private Integer articleType;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 短标题
     */
    private String shortTitle;

    /**
     * 文章头图
     */
    private String picture;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 类目 ID
     */
    private Long categoryId;

    /**
     * 来源：1-转载，2-原创，3-翻译
     */
    private Integer source;

    /**
     * 状态：0-未发布，1-已发布
     */
    private Integer status;
}
