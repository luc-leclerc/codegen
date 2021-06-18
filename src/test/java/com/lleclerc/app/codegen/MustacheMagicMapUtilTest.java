package com.lleclerc.app.codegen;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class MustacheMagicMapUtilTest {
    @Test
    public void toSafeJavaModel_happyPath() {
        // GIVEN
        Map<String, Object> subMap = Map.of("varA", "SomeThing", "varB", 123);
        Map<String, Object> map = Map.of("abc", "fancy-value", "a-map", subMap );

        // WHEN
        Map<Object, Object> result = MustacheMagicMapUtil.toSafeJavaModel(map);

        // THEN
        assertEquals("fancy-value", result.get("abc"));
        assertEquals("fancyvalue", result.get("abc_safeJava"));
        assertEquals("SomeThing", ((Map) result.get("a-map")).get("varA"));
        assertEquals("someThing", ((Map) result.get("a-map")).get("varA_safeJava"));
    }
}