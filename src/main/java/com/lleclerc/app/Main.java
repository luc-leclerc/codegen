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
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class Main extends AbstractMojo {

    @Parameter
    String basePackage = "com.lleclerc.codegen.generated";
    @Parameter
    String destinationPath = "./main/java/";
    @Parameter
    String yamlFilePath = "C:\\Users\\Luc\\git\\codegen\\src\\test\\resources\\sample.yml";

    @Override
    @SneakyThrows
    public void execute() throws MojoExecutionException, MojoFailureException {
        File file = new File("/home/table/Documents/" + LocalDate.now().toString() + ".txt");
        FileWriter fw = new FileWriter(file);
        fw.write("hey");
        fw.flush();

        JavaCodeGenUtil.executeJava(yamlFilePath, destinationPath, basePackage);
        System.out.println("Luc: codegen completed.");
    }
}
