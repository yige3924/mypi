package com.xieyun.paicoding.core.common.enums;

import lombok.Getter;

/**
 * 文章类型枚举
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Getter
public enum ArticleTypeEnum {

    EMPTY(0, ""),
    BLOG(1, "博文"),
    ANSWER(2, "问答");

    private final Integer code;
    private final String desc;

    ArticleTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ArticleTypeEnum formCode(Integer code) {
        for (ArticleTypeEnum value : ArticleTypeEnum.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return ArticleTypeEnum.EMPTY;
    }
}
