package com.lleclerc.app.codegen;

import com.lleclerc.service.java.ResourceUtil;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CodeGenUtilTest implements ResourceUtil {
    @Test
    public void cleanUpTemplate_doesNotFail() {
        // GIVEN
        String template = readResourceAsString("./template/ModelClass.java");

        // WHEN
        String cleanedTemplate = CodeGenUtil.cleanUpTemplate(template);

        // THEN
        assertNotNull(cleanedTemplate);
    }
}