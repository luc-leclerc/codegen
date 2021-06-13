package com.lleclerc.service.yml;

import com.lleclerc.service.java.ResourceUtil;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class YamlUtilTest implements ResourceUtil {
    @Test
    @SneakyThrows
    public void loadYaml() {
        // GIVEN
        InputStream is = readResource("yml-sample.yml");

        // WHEN
        Map<String, Object> test = YamlUtil.parseYaml_snakeyaml(is);

        // THEN
        assertEquals(111, test.get("aa"));
    }
}