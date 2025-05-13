package com.xieyun.paicoding.service.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类目管理表
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("category")
public class CategoryDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 状态：0-未发布，1-已发布
     */
    private Integer status;
}
