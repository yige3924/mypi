package com.xieyun.paicoding.core.common.enums;

import lombok.Getter;

/**
 * @author XieYun
 * @date 2025/5/14
 */
@Getter
public enum PushStatEnum {

    OFFLINE(0, "未发布"),
    ONLINE(1,"已发布");

    private final int code;
    private final String desc;

    PushStatEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PushStatEnum formCode(int code) {
        for (PushStatEnum yesOrNoEnum : PushStatEnum.values()) {
            if (yesOrNoEnum.getCode() == code) {
                return yesOrNoEnum;
            }
        }
        return PushStatEnum.OFFLINE;
    }
}
