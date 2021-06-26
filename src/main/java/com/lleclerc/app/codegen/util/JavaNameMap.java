package com.lleclerc.app.codegen.util;

import com.lleclerc.service.java.LazyReflectObjectMap;
import com.lleclerc.service.java.PatternUtil;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JavaNameMap extends LazyReflectObjectMap {
    Pattern SAFE_JAVA_SUFFIX = Pattern.compile("^(.*)_(safeJava)$");

    public JavaNameMap(Object object) {
        super(object);
    }

    @Override
    @SneakyThrows
    public boolean containsKey(Object key) {
        if (key instanceof String keyString) {
            Matcher matcher = SAFE_JAVA_SUFFIX.matcher(keyString);
            if (matcher.find()) {
                return super.containsKey(matcher.group(1));
            }
        }
        return super.containsKey(key);
    }

    @Override
    @SneakyThrows
    public Object get(Object key) {
        Object cache = super.cacheMap.get(key);
        if (cache != null) {
            return cache;
        }
        Object value = safeJavaGetValue(key);
        put(key, value);
        return value;
    }

    private Object safeJavaGetValue(Object object) {
        if (object instanceof String keyString) {
            Matcher matcher = SAFE_JAVA_SUFFIX.matcher(keyString);
            if (matcher.find()) {
                Object value = super.get(matcher.group(1));
                if (value instanceof String valueString) {
                    return PatternUtil.toSafeJavaName(valueString);
                }
            } else {
                Object value = super.get(object);
                if (value instanceof Map) {
                    return new JavaNameMap(value);
                }
                if (value instanceof List valueList) {
                    if (valueList.isEmpty() || valueList.get(0).getClass().getPackageName().startsWith("java.lang")) {
                        return valueList;
                    }
                    if (valueList.get(0) instanceof LazyReflectObjectMap) {
                        List<LazyReflectObjectMap> lazyMapList = (List<LazyReflectObjectMap>) valueList;
                        return lazyMapList.stream()
                                .map(LazyReflectObjectMap::getCoreObject)
                                .map(JavaNameMap::new)
                                .collect(Collectors.toList());
                    }
                    return valueList.stream().map(JavaNameMap::new).collect(Collectors.toList());
                }
            }
        }
        return super.get(object);
    }
}
