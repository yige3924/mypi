package com.xieyun.paicoding.core.common.enums;

import lombok.Getter;

/**
 * 状态枚举
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Getter
public enum YesOrNoEnum {

    NO(0, "N", "否", "no"),
    YES(1, "Y", "是", "yes");

    private final int code;
    private final String desc;
    private final String cnDesc;
    private final String enDesc;

    YesOrNoEnum(int code, String desc, String cnDesc, String enDesc) {
        this.code = code;
        this.desc = desc;
        this.cnDesc = cnDesc;
        this.enDesc = enDesc;
    }

    public static YesOrNoEnum formCode(int code) {
        for (YesOrNoEnum yesOrNoEnum : YesOrNoEnum.values()) {
            if (yesOrNoEnum.getCode() == code) {
                return yesOrNoEnum;
            }
        }
        return YesOrNoEnum.NO;
    }

    /**
     * 判断是否为 YES 或 NO，主要用于字段未赋值的情况
     */
    public static boolean equalYN(Integer code) {
        if (code == null) {
            return false;
        }
        if (code != null && (code.equals(YES.code) || code.equals(NO.code))) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为 YES
     */
    public static boolean isYes(Integer code) {
        if (code == null) {
            return false;
        }
        return YesOrNoEnum.YES.getCode() == code;
    }
}
