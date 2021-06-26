package com.lleclerc.app.codegen.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JavaNameMapTest {
    @Test
    public void toSafeJavaModel_happyPath_withClass() {
        // GIVEN
        JavaNameMap map = new JavaNameMap(new LazySafeJavaNameMapTestDummy());

        // WHEN-THEN
        assertEquals("fancy-value", map.get("abc"));
        assertEquals("fancyValue", map.get("abc_safeJava"));
    }

    public static class LazySafeJavaNameMapTestDummy {
        String abc = "fancy-value";
    }
}