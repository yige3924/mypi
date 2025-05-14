package com.xieyun.paicoding.core.common.enums;

import lombok.Getter;

/**
 * 文档类型枚举
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Getter
public enum DocumentTypeEnum {

    EMPTY(0, ""),
    DOCUMENT(1, "文章"),
    COMMENT(2, "评论");

    private final Integer code;
    private final String desc;

    DocumentTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static DocumentTypeEnum formCode(Integer code) {
        for (DocumentTypeEnum value : DocumentTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return DocumentTypeEnum.EMPTY;
    }
}
