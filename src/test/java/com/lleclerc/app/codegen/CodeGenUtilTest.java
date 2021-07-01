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
    @SneakyThrows
    public void compileModelToWriter() {
        // GIVEN
        String swaggerFile = "/home/table/git/codegen/src/test/resources/com/lleclerc/app/codegen/swagger-pet-sample.yml";
        String destinationPath = "/home/table/git/codegen/src/main/java";
        String basePackage = "com.lleclerc.app.codegen";

        // WHEN
        JavaCodeGenUtil.executeJava(swaggerFile, destinationPath, basePackage);

//        "base.package";
//        private static final String DESTINATION_PATH = "destination.path";
//        private static final String YAML_FILE_PATH = "yml.file.path";
        // java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=127.0.0.1:5005 -Dbase.package=com.lleclerc.generated -Ddestination.path=./src/main/java -Dyml.file.path=./src/test/resources/com/lleclerc/app/codegen/swagger-pet-sample.yml -jar /home/table/.m2/repository/com/lleclerc/codegen/1.0/codegen-1.0.jar
        // java -Dbase.package=com.lleclerc.generated -Ddestination.path=./src/main/java -Dyml.file.path=./src/test/resources/com/lleclerc/app/codegen/swagger-pet-sample.yml -jar /home/table/.m2/repository/com/lleclerc/codegen/1.0/codegen-1.0.jar
    }
}