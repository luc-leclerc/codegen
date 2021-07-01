//package com.lleclerc.app;
//
//import com.lleclerc.app.codegen.java.JavaCodeGenUtil;
//import lombok.SneakyThrows;
//import org.apache.maven.plugin.AbstractMojo;
//import org.apache.maven.plugin.MojoExecutionException;
//import org.apache.maven.plugin.MojoFailureException;
//import org.apache.maven.plugins.annotations.LifecyclePhase;
//import org.apache.maven.plugins.annotations.Mojo;
//import org.apache.maven.plugins.annotations.Parameter;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.time.LocalDate;
//
//@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
//public class Main extends AbstractMojo {
//
//    @Parameter
//    String basePackage = "com.lleclerc.codegen.generated";
//    @Parameter
//    String destinationPath = "./main/java/";
//    @Parameter
//    String yamlFilePath = "C:\\Users\\Luc\\git\\codegen\\src\\test\\resources\\sample.yml";
//
//    @Override
//    @SneakyThrows
//    public void execute() throws MojoExecutionException, MojoFailureException {
//        File file = new File("/home/table/Documents/" + LocalDate.now().toString() + ".txt");
//        FileWriter fw = new FileWriter(file);
//        fw.write("hey");
//        fw.flush();
//        fw.close();
//        System.out.println("end");
//
//        JavaCodeGenUtil.executeJava(yamlFilePath, destinationPath, basePackage);
//    }
//}
package com.lleclerc.app;

import com.lleclerc.app.codegen.java.JavaCodeGenUtil;
import lombok.SneakyThrows;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.lifecycle.Execution;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.FileSystemNotFoundException;
import java.time.LocalDate;

@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class FailedAttemptAtPlugin extends AbstractMojo {

    @Parameter
    String basePackage = "com.lleclerc.codegen.generated";
    @Parameter
    String destinationPath = "./main/java/";
    @Parameter
    String yamlFilePath = "C:\\Users\\Luc\\git\\codegen\\src\\test\\resources\\sample.yml";

    // I could debug in execute() method, but it wasn't able to resolve dependencies when calling JavaCodeGenUtil, see:

//    [INFO] BUILD FAILURE
//[INFO] ------------------------------------------------------------------------
//            [INFO] Total time:  0.623 s
//[INFO] Finished at: 2021-07-01T10:42:11-04:00
//            [INFO] ------------------------------------------------------------------------
//            [ERROR] Failed to execute goal com.lleclerc:codegen:4.5:generate-sources (default) on project pdf: Execution
//    default of goal com.lleclerc:codegen:4.5:generate-sources failed: An API incompatibility was encountered while executing com.lleclerc:codegen:4.5:generate-sources: java.lang.ExceptionInInitializerError: null
//            [ERROR] -----------------------------------------------------
//            [ERROR] realm =    plugin>com.lleclerc:codegen:4.5
//            [ERROR] strategy = org.codehaus.plexus.classworlds.strategy.SelfFirstStrategy
//[ERROR] urls[0] = file:/home/table/.m2/repository/com/lleclerc/codegen/4.5/codegen-4.5.jar
//[ERROR] urls[1] = file:/home/table/.m2/repository/org/apache/commons/commons-lang3/3.8.1/commons-lang3-3.8.1.jar
//[ERROR] urls[2] = file:/home/table/.m2/repository/javax/enterprise/cdi-api/1.0/cdi-api-1.0.jar
//[ERROR] urls[3] = file:/home/table/.m2/repository/org/eclipse/sisu/org.eclipse.sisu.inject/0.3.4/org.eclipse.sisu.inject-0.3.4.jar
//[ERROR] urls[4] = file:/home/table/.m2/repository/org/codehaus/plexus/plexus-component-annotations/1.5.5/plexus-component-annotations-1.5.5.jar
//[ERROR] urls[5] = file:/home/table/.m2/repository/org/codehaus/plexus/plexus-utils/3.2.1/plexus-utils-3.2.1.jar
//[ERROR] urls[6] = file:/home/table/.m2/repository/org/apache/maven/plugin-tools/maven-plugin-annotations/3.6.1/maven-plugin-annotations-3.6.1.jar
//[ERROR] urls[7] = file:/home/table/.m2/repository/com/github/spullara/mustache/java/compiler/0.9.7/compiler-0.9.7.jar
//[ERROR] urls[8] = file:/home/table/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.11.1/jackson-dataformat-yaml-2.11.1.jar
//[ERROR] urls[9] = file:/home/table/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.11.1/jackson-databind-2.11.1.jar
//[ERROR] urls[10] = file:/home/table/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.11.1/jackson-annotations-2.11.1.jar
//[ERROR] urls[11] = file:/home/table/.m2/repository/org/yaml/snakeyaml/1.26/snakeyaml-1.26.jar
//[ERROR] urls[12] = file:/home/table/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.11.1/jackson-core-2.11.1.jar
//[ERROR] Number of foreign imports: 1
//            [ERROR] import: Entry[import  from realm ClassRealm[maven.api, parent: null]]
//            [ERROR]
//            [ERROR] -----------------------------------------------------
//            [ERROR] : FileSystemNotFoundException
//[ERROR] -> [Help 1]
//            [ERROR]
//            [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
//            [ERROR] Re-run Maven using the -X switch to enable full debug logging.
//[ERROR]
//            [ERROR] For more information about the errors and possible solutions, please read the following articles:
//            [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/PluginContainerException
//    t
    @Override
    @SneakyThrows
    public void execute() throws MojoExecutionException, MojoFailureException {
        File file = new File("/home/table/Documents/" + LocalDate.now().toString() + ".txt");
        FileWriter fw = new FileWriter(file);
        fw.write("hey");
        fw.flush();

        JavaCodeGenUtil.executeJava(yamlFilePath, destinationPath, basePackage);
        System.out.println("Codegen completed.");
    }
}
