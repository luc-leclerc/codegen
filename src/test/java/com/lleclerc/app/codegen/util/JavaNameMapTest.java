package com.lleclerc.app.codegen.util;

import lombok.Value;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JavaNameMapTest {


    @Test
    public void toSafeJavaModel_happyPath_withClass() {
        // GIVEN
        JavaNameMap map = new JavaNameMap(new LazySafeJavaNameMapTestDummy());

        // WHEN-THEN
        assertEquals("fancy-value", map.get("abc"));
        assertEquals("fancyvalue", map.get("abc_safeJava"));
        
    }

    @Value
    public static class LazySafeJavaNameMapTestDummy {
        String abc = "fancy-value";
    }
}