package com.xieyun.paicoding.core.util;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 支持跨源资源共享
 *
 * @author XieYun
 * @date 2025/5/11
 */
public class CrossUtil {

    /**
     * 支持跨域
     *
     * @param request
     * @param response
     */
    public static void buildCors(HttpServletRequest request, HttpServletResponse response) {
        String origin = request.getHeader("Origin");
        if (StringUtils.isBlank(origin)) {
            response.setHeader("Access-Control-Allow-Origin", "*");
        } else {
            response.setHeader("Access-Control-Allow-Origin", origin);
        }

        /**
         * fixme 这里不确定为什么要写
         */
        // response.setHeader("Access-Control-Allow-Origin". request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, " +
                "Accept, X-Real-IP, X-Forwarded-For, d-uuid, User-Agent, x-zd-cs, Proxy-Client-IP, HTTP_CLIENT_IP, " +
                "HTTP_X_FORWARDED_FOR");
    }
}
