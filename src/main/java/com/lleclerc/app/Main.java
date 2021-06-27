package com.lleclerc.app;

import lombok.SneakyThrows;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;

@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class Main extends AbstractMojo {

    @Parameter
    String packageName = "com.lleclerc.codegen.generated";
    @Parameter
    String folderDestination = "./main/java/";
    @Parameter
    String swaggerFilePath = "C:\\Users\\Luc\\git\\codegen\\src\\test\\resources\\sample.yml";

    @Override
    @SneakyThrows
    public void execute() throws MojoExecutionException, MojoFailureException {
        File file = new File("/home/table/Documents/" + packageName);
        FileWriter fw = new FileWriter(file);
        fw.write("hey");
        fw.flush();
        fw.close();
        System.out.println("end");
    }
}
