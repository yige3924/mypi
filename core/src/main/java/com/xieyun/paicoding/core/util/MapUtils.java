package com.xieyun.paicoding.core.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XieYun
 * @date 2025/5/11
 */
public class MapUtils {

    public static <K, V> Map<K, V> create(K k, V v, Object... kvs) {
        Map<K, V> map = new HashMap<>(kvs.length + 1);
        map.put(k, v);
        for (int i = 0; i < kvs.length; i += 2) {
            map.put((K) kvs[i], (V) kvs[i + 1]);
        }
        return map;
    }
}
