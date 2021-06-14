package com.lleclerc.app.codegen;

import com.lleclerc.service.java.ResourceUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrepareTemplateUtilTest implements ResourceUtil {

    @Test
    public void testt() {

        String template = readResourceAsString("./template/ModelClass.java");
        String cleanedTemplate = PrepareTemplateUtil.cleanUpTemplate(template);
        System.out.println(cleanedTemplate);
    }
}