package com.lleclerc.codegen.service;

import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MustacheCompilerServiceTest {

    @Test
    public void compile_happyPath_works() {
        // GIVEN
        String template = "Hello {{{abc}}}!";
        Map<String, Object> model = Collections.singletonMap("abc", "world");

        // WHEN
        String result = MustacheCompilerService.compileStandalone(template, model);

        // THEN
        assertEquals("Hello world!", result);
    }
}