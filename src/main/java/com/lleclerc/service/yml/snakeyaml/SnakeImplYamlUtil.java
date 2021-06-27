package com.lleclerc.service.yml.snakeyaml;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

/**
 * Notes:
 * - Yaml class is not thread safe.
 */
public interface SnakeImplYamlUtil {

    static Map<String, Object> parseInputStream(InputStream is) {
        return new Yaml().load(is);
    }

    // Not sure this works, it doesn't work on incomplete model class definition
    static <T> T parseInputStream(InputStream is, Class<T> clazz) {
        return new Yaml().loadAs(is, clazz);
    }
}
