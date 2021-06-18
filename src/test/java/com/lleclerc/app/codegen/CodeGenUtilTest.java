package com.lleclerc.app.codegen;

import com.lleclerc.app.codegen.model.JavaClass;
import com.lleclerc.app.codegen.model.JavaClassProperty;
import com.lleclerc.service.java.ResourceUtil;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.StringWriter;

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

    @Test
    @SneakyThrows
    public void compileModelToWriter() {
        // GIVEN
        JavaClass javaClass = JavaClass.builder()
                .packageName("com.luc.test")
                .className("Hello")
                .property(JavaClassProperty.builder()
                        .propertyName("abc")
                        .defaultValue("\"value\"")
                        .type("String").build()).build();
        StringWriter stringWriter = new StringWriter();

        // WHEN
        CodeGenUtil.compileModelToWriter(javaClass, stringWriter);

        // THEN
        assertNotNull(stringWriter.toString());
        System.out.println(stringWriter);
    }
}