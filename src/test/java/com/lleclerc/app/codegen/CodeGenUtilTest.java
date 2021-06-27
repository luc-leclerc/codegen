package com.lleclerc.app.codegen;

import com.lleclerc.app.codegen.java.JavaCodeGenUtil;
import com.lleclerc.app.codegen.java.model.JavaClass;
import com.lleclerc.app.codegen.java.model.JavaClassProperty;
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
        String cleanedTemplate = JavaCodeGenUtil.cleanUpTemplate(template);

        // THEN
        assertNotNull(cleanedTemplate);
    }

    @Test
    @SneakyThrows
    public void compileModelToWriter() {
        // GIVEN
        String swaggerFile = "/home/table/git/codegen/src/test/resources/com/lleclerc/app/codegen/swagger-pet-sample.yml";
        String destinationPath = "/home/table/git/codegen/src/main/java";
        String basePackage = "com.lleclerc.app.codegen";
        // WHEN
        JavaCodeGenUtil.executeJava(swaggerFile, destinationPath, basePackage);
    }
}