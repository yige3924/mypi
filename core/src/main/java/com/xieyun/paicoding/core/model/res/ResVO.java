package com.xieyun.paicoding.core.model.res;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XieYun
 * @date 2025/5/11
 */
@Data
public class ResVO<T> implements Serializable {
    private static final long serialVersionUID = -510306209659393854L;

    private Status status;
    private T result;

    public ResVO() {}

    public ResVO(int code, String msg) {
        status = new Status(code, msg);
    }

    public ResVO(T t) {
        status = Status.newStatus(0, "ok");
        this.result = t;
    }

    public static <T> ResVO<T> successReturn(T t) {
        return new ResVO<T>(t);
    }

    @SuppressWarnings("unchecked")
    public static <T> ResVO<T> errorReturn(Status status, String... msgs) {
        String msg;
        if (msgs.length > 0) {
            msg = String.format(status.getMsg(), msgs);
        } else {
            msg = status.getMsg();
        }
        return new ResVO<T>(status.getCode(), msg);
    }
}
