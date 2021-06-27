package com.lleclerc.service.yml;

import com.lleclerc.service.java.ResourceUtil;
import com.lleclerc.service.yml.snakeyaml.SnakeImplYamlUtil;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SnakeImplYamlUtilTest implements ResourceUtil {
    @Test
    @SneakyThrows
    public void loadYaml() {
        // GIVEN
        InputStream is = readResource("yml-sample.yml");

        // WHEN
        Map<String, Object> test = SnakeImplYamlUtil.parseInputStream(is);

        // THEN
        assertEquals(111, test.get("aa"));
    }
}