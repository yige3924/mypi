package com.xieyun.paicoding.service.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xieyun.paicoding.core.common.enums.CollectionStatEnum;
import com.xieyun.paicoding.core.common.enums.CommentStatEnum;
import com.xieyun.paicoding.core.common.enums.PraiseStatEnum;
import com.xieyun.paicoding.service.repository.entity.UserDTO;
import com.xieyun.paicoding.service.repository.entity.UserFootDTO;
import com.xieyun.paicoding.service.repository.entity.UserInfoDTO;
import com.xieyun.paicoding.service.repository.entity.UserRelationDTO;
import com.xieyun.paicoding.service.repository.param.PageParam;

import java.util.List;

/**
 * 用户相关数据库操作
 *
 * @author XieYun
 * @date 2025/5/13
 */
public interface UserRepository {

    /**
     * 添加用户
     */
    Long addUser(UserDTO userDTO);

    /**
     * 更新用户
     */
    void updateUser(UserDTO userDTO);

    /**
     * 删除用户
     */
    void deleteUser(Long userInfoId);

    /**
     * 添加用户信息
     */
    Long addUserInfo(UserInfoDTO userInfoDTO);

    /**
     * 更新用户信息
     */
    void updateUserInfo(UserInfoDTO userInfoDTO);

    /**
     * 删除用户信息
     */
    void deleteUserInfo(Long userId);

    /**
     * 查询用户信息
     */
    UserInfoDTO getUserInfoByUserId(Long userId);

    /**
     * 添加用户关系
     */
    Long addUserRelation(UserRelationDTO userRelationDTO);

    /**
     * 获取关注用户列表
     */
    IPage<UserRelationDTO> getUserRelationListByUserId(Integer userId, PageParam pageParam);

    /**
     * 获取被关注用户列表
     */
    IPage<UserRelationDTO> getUserRelationListByFollowUserId(Integer followUserId, PageParam pageParam);

    /**
     * 删除用户关系
     */
    void deleteUserRelationById(Long id);

    /**
     * 添加用户足迹
     */
    Long addUserFoot(UserFootDTO userFootDTO);

    /**
     * 文章收藏数
     */
    Integer queryCollectionCount(Long documentId);

    /**
     * 文章阅读数
     */
    Integer queryReadCount(Long documentId);

    /**
     * 文章评论数
     */
    Integer queryCommentCount(Long documentId);

    /**
     * 文章点赞数
     */
    Integer queryPraiseCount(Long documentId);

    /**
     * 收藏/取消收藏足迹
     */
    Integer operateCollectionFoot(Long documentId, Long userId, CollectionStatEnum statEnum);

    /**
     * 评论/删除评论足迹
     */
    Integer operateCommentFoot(Long documentId, Long userId, CommentStatEnum statEnum);

    /**
     * 点赞/取消点赞足迹
     */
    Integer operatePraiseFoot(Long documentId, Long userId, PraiseStatEnum statEnum);
}
