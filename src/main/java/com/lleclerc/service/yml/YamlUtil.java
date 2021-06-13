package com.lleclerc.service.yml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

/**
 * Notes:
 * - Yaml class is not thread safe.
 */
public interface YamlUtil {

    static Map<String, Object> parseYaml_snakeyaml(InputStream is) {
        return new Yaml().load(is);
    }

    /**
     * Note: Not sure this works, it doesn't work on incomplete model class definition
     */
    static <T> T parseYaml_snakeyaml(InputStream is, Class<T> clazz) {
        return new Yaml().loadAs(is, clazz);
    }

    @SneakyThrows
    static JsonNode parseYaml_jackson(InputStream is) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(is, JsonNode.class);
    }

    @SneakyThrows
    static <T> T parseYaml_jackson(InputStream is, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(is, clazz);
    }

    @SneakyThrows
    static String writeYaml_jackson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.writeValueAsString(object);
    }
}
