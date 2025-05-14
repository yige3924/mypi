package com.xieyun.paicoding.service.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户足迹表
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user_foot")
public class UserFootDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 文档 ID（文章/评论）
     */
    private Long documentId;

    /**
     * 文档类型：1-文章，2-评论
     */
    private Long documentType;

    /**
     * 收藏状态：0-未收藏，1-已收藏，2-取消收藏
     */
    private Integer collectionStat;

    /**
     * 阅读状态：0-未读，1-已读
     */
    private Integer readStat;

    /**
     * 评论状态：0-未评论，1-已评论，2-删除评论
     */
    private Integer commentStat;

    /**
     * 点赞状态：0-未点赞，1-已点赞，2-取消点赞
     */
    private Integer praiseStat;
}
