package com.xieyun.paicoding.web.hook.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * POST 请求数据封装，避免因为打印日志导致请求参数被提前消费
 *
 * @author XieYun
 * @date 2025/5/13
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private static final List<String> POST_METHOD = Arrays.asList("POST", "PUT");

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final byte[] body;

    private final String bodyString;

    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);

        if (POST_METHOD.contains(request.getMethod()) && !isMultipart(request) && !isBinaryContent(request)) {
            bodyString = getBodyString(request);
            body = bodyString.getBytes(StandardCharsets.UTF_8);
        } else {
            bodyString = null;
            body = null;
        }
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (body == null) {
            return super.getInputStream();
        }

        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }

    public boolean hasPayload() {
        return bodyString != null;
    }

    public String getBodyString() {
        return bodyString;
    }

    private String getBodyString(HttpServletRequest request) {
        BufferedReader br;
        try {
            br = request.getReader();
        } catch (IOException e) {
            logger.warn("Failed to get reader", e);
            return "";
        }

        String str;
        StringBuilder body = new StringBuilder();
        try {
            while ((str = br.readLine()) != null) {
                body.append(str);
            }
        } catch (IOException e) {
            logger.warn("Failed to read line", e);
        }

        try {
            br.close();
        } catch (IOException e) {
            logger.warn("Failed to close reader", e);
        }

        return body.toString();
    }

    private boolean isBinaryContent(HttpServletRequest request) {
        return request.getContentType() != null &&
                (request.getContentType().startsWith("image") ||
                        request.getContentType().startsWith("video") ||
                        request.getContentType().startsWith("audio"));
    }

    private boolean isMultipart(HttpServletRequest request) {
        return request.getContentType() != null &&
                request.getContentType().startsWith("multipart/form-data");
    }
}
