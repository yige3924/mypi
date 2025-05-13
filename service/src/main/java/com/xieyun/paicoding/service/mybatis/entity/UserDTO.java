package com.xieyun.paicoding.service.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户登录表
 *
 * @author XieYun
 * @date 2025/5/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class UserDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 第三方用户 ID
     */
    private String thirdAccountId;

    /**
     * 登录方式：0-微信登录，1-账号密码登录
     */
    private Integer loginType;
}
