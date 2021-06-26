package com.lleclerc.service.java;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class LazyReflectObjectMap implements Map<Object, Object> {
    final Map<Object, Object> map = new HashMap<>();
    final Object object;

    public LazyReflectObjectMap(Object object) {
        this.object = object;
    }

    @Override
    @SneakyThrows
    public boolean containsKey(Object key) {
        if (key instanceof String keyString) {
            return object.getClass().getDeclaredField(keyString) != null;
        }
        return false;
    }

    @Override
    @SneakyThrows
    public Object get(Object key) {
        Object cache = map.get(key);
        if (cache != null) {
            return cache;
        }
        if (key instanceof String keyString) {
            Field field = object.getClass().getDeclaredField(keyString);
            field.setAccessible(true);
            Object value = field.get(object);
            if (value == null) {
                return null;
            }
            if (value.getClass().getPackageName().startsWith("java.lang")) {
                map.put(key, value);
                return value;
            }
            if (value instanceof List valueList) {
                if (valueList.isEmpty() || valueList.get(0).getClass().getPackageName().startsWith("java.lang")) {
                    put(key, value);
                    return valueList;
                }
                List<Object> withLazyWrap = (List<Object>) valueList.stream().map(LazyReflectObjectMap::new).collect(Collectors.toList());
                put(key, withLazyWrap);
                return withLazyWrap;
            }
            LazyReflectObjectMap subObject = new LazyReflectObjectMap(value);
            put(key, subObject);
            return subObject;
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<?, ?> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<Object> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<Object> values() {
        return map.values();
    }

    @Override
    public Set<Entry<Object, Object>> entrySet() {
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public boolean equals(Object o) {
        return map.equals(o);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }
}
