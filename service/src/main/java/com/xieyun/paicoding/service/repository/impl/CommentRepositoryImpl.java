package com.xieyun.paicoding.service.repository.impl;

import com.xieyun.paicoding.service.repository.CommentRepository;
import com.xieyun.paicoding.service.repository.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 评论相关数据库操作
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Service
public class CommentRepositoryImpl implements CommentRepository {

    @Resource
    private CommentMapper commentMapper;
}
