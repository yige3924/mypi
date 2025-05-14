package com.xieyun.paicoding.service.repository.param;

import lombok.Data;

/**
 * 数据库分页参数
 *
 * @author XieYun
 * @date 2025/5/14
 */
@Data
public class PageParam {

    public static final Long DEFAULT_PAGE_NUM = 1L;
    public static final Long DEFAULT_PAGE_SIZE = 100L;


    private long pageNum;
    private long pageSize;
    private long offset;
    private long limit;

    public static PageParam newPageInstance(Long pageNum, Long pageSize) {

        if (pageNum == null || pageSize == null){
            return null;
        }

        final PageParam pageParam = new PageParam();
        pageParam.pageNum = pageNum;
        pageParam.pageSize = pageSize;

        pageParam.offset = (pageNum - 1) * pageSize;
        pageParam.limit = pageSize;

        return pageParam;
    }

    public static String getLimitSql(PageParam pageParam){
        return String.format("limit %s,%s" , pageParam.offset,pageParam.limit);
    }
}
