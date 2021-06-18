package com.lleclerc.app.codegen;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unchecked")
public interface MustacheMagicMapUtil {
    Pattern SAFE_JAVA_SUFFIX = Pattern.compile("^(.*)_(safeJava)$");
    Pattern SAFE_JAVA_REPLACE = Pattern.compile("[^a-zA-Z]");
    ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static Map<Object, Object> toSafeJavaModel(Object object) {
        if (object instanceof Map objectMap) {
            return recursive_toSafeJavaMap(objectMap);
        }
        return recursive_toSafeJavaMap(OBJECT_MAPPER.convertValue(object, Map.class));
    }

    static Map<Object, Object> recursive_toSafeJavaMap(Map<Object, Object> map) {
        Map<Object, Object> decorated = toSafeJavaMap(map);
        for (Map.Entry<Object, Object> entry : decorated.entrySet()) {
            if (entry.getValue() instanceof Map valueMap) {
                entry.setValue(recursive_toSafeJavaMap(valueMap));
            }
        }
        return decorated;
    }

    private static Map<Object, Object> toSafeJavaMap(Map<?, ?> map) {
        return new HashMap<>(map) {
            @Override
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
        };
    }
}
