package com.lleclerc.service.java;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PatternUtilTest {
    @Test
    public void toSafeJavaName() {
        assertEquals("myTestValue", PatternUtil.toCamelCaseWithLettersOnly("my-tes{t--value"));
    }
}