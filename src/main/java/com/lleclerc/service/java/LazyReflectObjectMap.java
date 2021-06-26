package com.lleclerc.service.java;

import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class LazyReflectObjectMap implements Map<Object, Object> {
    protected final Map<Object, Object> cacheMap = new HashMap<>();
    @Getter
    final Object coreObject;

    public LazyReflectObjectMap(Object coreObject) {
        this.coreObject = coreObject;
    }

    @Override
    @SneakyThrows
    public boolean containsKey(Object key) {
        if (key instanceof String keyString) {
            return coreObject.getClass().getDeclaredField(keyString) != null;
        }
        return false;
    }

    @Override
    @SneakyThrows
    public Object get(Object key) {
        Object cache = cacheMap.get(key);
        if (cache != null) {
            return cache;
        }
        Object value = reflectiveGetValue(key);
        put(key, value);
        return value;
    }

    @SneakyThrows
    private Object reflectiveGetValue(Object key) {
        if (key instanceof String keyString) {
            Field field = coreObject.getClass().getDeclaredField(keyString);
            field.setAccessible(true);
            Object value = field.get(coreObject);

            if (value == null || value.getClass().getPackageName().startsWith("java.lang"))
                return value;
            if (value instanceof List valueList) {
                if (valueList.isEmpty() || valueList.get(0).getClass().getPackageName().startsWith("java.lang")) {
                    return valueList;
                }
                return valueList.stream().map(LazyReflectObjectMap::new).collect(Collectors.toList());
            }
            return new LazyReflectObjectMap(value);
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return cacheMap.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return cacheMap.remove(key);
    }

    @Override
    public void putAll(Map<?, ?> m) {
        cacheMap.putAll(m);
    }

    @Override
    public void clear() {
        cacheMap.clear();
    }

    @Override
    public Set<Object> keySet() {
        return cacheMap.keySet();
    }

    @Override
    public Collection<Object> values() {
        return cacheMap.values();
    }

    @Override
    public Set<Entry<Object, Object>> entrySet() {
        return null;
    }

    @Override
    public int size() {
        return cacheMap.size();
    }

    @Override
    public boolean isEmpty() {
        return cacheMap.isEmpty();
    }

    @Override
    public boolean containsValue(Object value) {
        return cacheMap.containsValue(value);
    }

    @Override
    public boolean equals(Object o) {
        return cacheMap.equals(o);
    }

    @Override
    public int hashCode() {
        return cacheMap.hashCode();
    }
}
