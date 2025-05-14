package com.xieyun.paicoding.service.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评论表
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("comment")
public class CommentDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 文章 ID
     */
    private Long articleId;

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 评论内容
     */
    private String version;

    /**
     * 父评论 ID
     */
    private Integer parentCommentId;

    private Integer deleted;
}
