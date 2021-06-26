package com.lleclerc.app.codegen.util;

import com.lleclerc.service.java.LazyReflectObjectMap;
import lombok.SneakyThrows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaNameMap extends LazyReflectObjectMap {
    Pattern SAFE_JAVA_SUFFIX = Pattern.compile("^(.*)_(safeJava)$");
    Pattern SAFE_JAVA_REPLACE = Pattern.compile("[^a-zA-Z]");

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
        if (key instanceof String keyString) {
            Matcher matcher = SAFE_JAVA_SUFFIX.matcher(keyString);
            if (matcher.find() && super.get(matcher.group(1)) instanceof String valueString) {
                String cleanedValue = SAFE_JAVA_REPLACE.matcher(valueString).replaceAll("");
                return cleanedValue.substring(0, 1).toLowerCase() + cleanedValue.substring(1);
            }
        }
        return super.get(key);
    }
}
