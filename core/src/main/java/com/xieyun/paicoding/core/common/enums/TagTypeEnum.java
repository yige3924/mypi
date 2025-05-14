package com.xieyun.paicoding.core.common.enums;

import lombok.Getter;

/**
 * 标签类型枚举
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Getter
public enum TagTypeEnum {

    SYSTEM_TAG(1, "系统标签"),
    CUSTOM_TAG(2, "已读");

    private final Integer code;
    private final String desc;

    TagTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static TagTypeEnum formCode(Integer code) {
        for (TagTypeEnum value : TagTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return TagTypeEnum.SYSTEM_TAG;
    }
}
