package com.lleclerc.service.yml.jackson;

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
public interface JacksonImplYamlUtil {
    @SneakyThrows
    static JsonNode parseInputStream(InputStream is) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(is, JsonNode.class);
    }

    @SneakyThrows
    static <T> T parseInputStream(InputStream is, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(is, clazz);
    }

    @SneakyThrows
    static String toString(Object object) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.writeValueAsString(object);
    }
}
