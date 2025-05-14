package com.xieyun.paicoding.service.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xieyun.paicoding.core.common.enums.PushStatEnum;
import com.xieyun.paicoding.service.repository.entity.ArticleDTO;
import com.xieyun.paicoding.service.repository.entity.CategoryDTO;
import com.xieyun.paicoding.service.repository.entity.TagDTO;
import com.xieyun.paicoding.service.repository.param.PageParam;

import java.util.List;

/**
 * 文章相关数据库操作
 *
 * @author XieYun
 * @date 2025/5/13
 */
public interface ArticleRepository {

    /**
     * 添加类目
     */
    Long addCategory(CategoryDTO categoryDTO);

    /**
     * 更新类目
     */
    void updateCategory(Integer categoryId, String categoryName);

    /**
     * 删除类目
     */
    void deleteCategory(Integer categoryId);

    /**
     * 操作类目
     */
    void operateCategory(Integer categoryId, PushStatEnum pushStatEnum);

    /**
     * 类目分页查询
     */
    IPage<CategoryDTO> getCategoryByPage(PageParam pageParam);

    /**
     * 添加标签
     */
    Long addTag(TagDTO tagDTO);

    /**
     * 更新标签
     */
    void updateTag(Integer tagId, String tagName);

    /**
     * 删除标签
     */
    void deleteTag(Integer tagId);

    /**
     * 上线/下线标签
     */
    void operateTag(Integer tagId, PushStatEnum pushStatEnum);

    /**
     * 标签分页查询
     */
    IPage<TagDTO> getTagByPage(PageParam pageParam);

    /**
     * 根据类目 ID 查询标签列表
     */
    List<TagDTO> getTagListByCategoryId(Long categoryId);

    /**
     * 新增文章
     */
    Long addArticle(ArticleDTO articleDTO);

    /**
     * 更新文章
     */
    void updateArticle(ArticleDTO articleDTO);

    /**
     * 删除文章
     */
    void deleteArticle(Long articleId);

    /**
     * 上线/下线文章
     */
    void operateArticle(Long articleId, PushStatEnum pushStatEnum);

    /**
     * 分页获取文章列表
     */
    IPage<ArticleDTO> getArticleByPage(PageParam pageParam);

}
