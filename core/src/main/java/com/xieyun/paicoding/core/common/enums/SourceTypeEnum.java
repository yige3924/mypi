package com.xieyun.paicoding.core.common.enums;

import lombok.Getter;

/**
 * 文档来源枚举
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Getter
public enum SourceTypeEnum {

    EMPTY(0, ""),
    REPRINT(1, "转载"),
    ORIGINAL(2, "原创"),
    TRANSLATION(3, "翻译");

    private final Integer code;
    private final String desc;

    SourceTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SourceTypeEnum formCode(Integer code) {
        for (SourceTypeEnum value : SourceTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return SourceTypeEnum.EMPTY;
    }
}
