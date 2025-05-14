package com.xieyun.paicoding.service.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyun.paicoding.core.common.enums.PushStatEnum;
import com.xieyun.paicoding.core.common.enums.YesOrNoEnum;
import com.xieyun.paicoding.service.repository.ArticleRepository;
import com.xieyun.paicoding.service.repository.entity.ArticleDTO;
import com.xieyun.paicoding.service.repository.entity.CategoryDTO;
import com.xieyun.paicoding.service.repository.entity.TagDTO;
import com.xieyun.paicoding.service.repository.mapper.*;
import com.xieyun.paicoding.service.repository.param.PageParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章相关数据库操作
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Service
public class ArticleRepositoryImpl implements ArticleRepository {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private TagMapper tagMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private ArticleTagMapper articleTagMapper;

    @Resource
    private ArticleDetailMapper articleDetailMapper;

    @Override
    public Long addCategory(CategoryDTO categoryDTO) {
        categoryMapper.insert(categoryDTO);
        return categoryDTO.getId();
    }

    @Override
    public void updateCategory(Integer categoryId, String categoryName) {
        CategoryDTO categoryDTO = categoryMapper.selectById(categoryId);
        if (categoryDTO != null) {
            categoryDTO.setCategoryName(categoryName);
            categoryDTO.setStatus(YesOrNoEnum.NO.getCode());
            categoryMapper.updateById(categoryDTO);
        }
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        CategoryDTO categoryDTO = categoryMapper.selectById(categoryId);
        if (categoryDTO != null) {
            categoryDTO.setDeleted(YesOrNoEnum.YES.getCode());
            categoryMapper.updateById(categoryDTO);
        }
    }

    @Override
    public void operateCategory(Integer categoryId, PushStatEnum pushStatEnum) {
        CategoryDTO categoryDTO = categoryMapper.selectById(categoryId);
        if (categoryDTO != null) {
            categoryDTO.setStatus(pushStatEnum.getCode());
            categoryMapper.updateById(categoryDTO);
        }
    }

    @Override
    public IPage<CategoryDTO> getCategoryByPage(PageParam pageParam) {
        LambdaQueryWrapper<CategoryDTO> query = Wrappers.lambdaQuery();
        query.eq(CategoryDTO::getDeleted, YesOrNoEnum.NO.getCode())
                .eq(CategoryDTO::getStatus, PushStatEnum.ONLINE.getCode());
        Page page = new Page(pageParam.getPageNum(), pageParam.getPageSize());
        return categoryMapper.selectPage(page, query);
    }

    @Override
    public Long addTag(TagDTO tagDTO) {
        tagMapper.insert(tagDTO);
        return tagDTO.getId();
    }

    @Override
    public void updateTag(Integer tagId, String tagName) {
        TagDTO tagDTO = tagMapper.selectById(tagId);
        if (tagDTO != null) {
            tagDTO.setTagName(tagName);
            tagDTO.setStatus(YesOrNoEnum.NO.getCode());
            tagMapper.updateById(tagDTO);
        }
    }

    @Override
    public void deleteTag(Integer tagId) {
        TagDTO tagDTO = tagMapper.selectById(tagId);
        if (tagDTO != null) {
            tagDTO.setDeleted(YesOrNoEnum.YES.getCode());
            tagMapper.updateById(tagDTO);
        }
    }

    @Override
    public void operateTag(Integer tagId, PushStatEnum pushStatEnum) {
        TagDTO tagDTO = tagMapper.selectById(tagId);
        if (tagDTO != null) {
            tagDTO.setStatus(pushStatEnum.getCode());
            tagMapper.updateById(tagDTO);
        }
    }

    @Override
    public IPage<TagDTO> getTagByPage(PageParam pageParam) {
        LambdaQueryWrapper<TagDTO> query = Wrappers.lambdaQuery();
        query.eq(TagDTO::getDeleted, YesOrNoEnum.NO.getCode())
                .eq(TagDTO::getStatus, PushStatEnum.ONLINE.getCode());;
        Page page = new Page(pageParam.getPageNum(), pageParam.getPageSize());
        return tagMapper.selectPage(page, query);
    }

    @Override
    public List<TagDTO> getTagListByCategoryId(Long categoryId) {
        LambdaQueryWrapper<TagDTO> query = Wrappers.lambdaQuery();
        query.eq(TagDTO::getDeleted, YesOrNoEnum.NO.getCode())
                .eq(TagDTO::getCategoryId, categoryId);
        return tagMapper.selectList(query);
    }

    @Override
    public Long addArticle(ArticleDTO articleDTO) {
        articleMapper.insert(articleDTO);
        return articleDTO.getId();
    }

    @Override
    public void updateArticle(ArticleDTO articleDTO) {
        ArticleDTO updateArticle = articleMapper.selectById(articleDTO.getId());
        if (updateArticle != null) {
            articleMapper.updateById(articleDTO);
        }
    }

    @Override
    public void deleteArticle(Long articleId) {
        ArticleDTO articleDTO = articleMapper.selectById(articleId);
        if (articleDTO != null) {
            articleDTO.setDeleted(YesOrNoEnum.YES.getCode());
            articleMapper.updateById(articleDTO);
        }
    }

    @Override
    public void operateArticle(Long articleId, PushStatEnum pushStatEnum) {
        ArticleDTO articleDTO = articleMapper.selectById(articleId);
        if (articleDTO != null) {
            articleDTO.setStatus(pushStatEnum.getCode());
            articleMapper.updateById(articleDTO);
        }
    }

    @Override
    public IPage<ArticleDTO> getArticleByPage(PageParam pageParam) {
        LambdaQueryWrapper<ArticleDTO> query = Wrappers.lambdaQuery();
        query.eq(ArticleDTO::getDeleted, YesOrNoEnum.NO.getCode())
                .eq(ArticleDTO::getStatus,PushStatEnum.ONLINE.getCode());
        Page page = new Page(pageParam.getPageNum(), pageParam.getPageSize());
        return articleMapper.selectPage(page, query);
    }
}
