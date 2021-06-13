package com.lleclerc.app;

import lombok.SneakyThrows;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

//@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class Main  {

    @Parameter
    String packageName = "com.lleclerc.codegen.generated";
    @Parameter
    String folderDestimation = "./main/java/";
    @Parameter
    String swaggerFilePath = "C:\\Users\\Luc\\git\\codegen\\src\\test\\resources\\sample.yml";

    @SneakyThrows
    public static void main(String[] args) {
        Main plugin = new Main();

        plugin.execute();
    }

//    @Override
    @SneakyThrows
    public void execute() throws MojoExecutionException, MojoFailureException {
//        Map<String, Object> swaggerMap = parseYaml(swaggerFilePath);
//        Map<String, Object> mustacheMap = toMustacheModel(swaggerMap);
//        File file = new File("testtt.txt");
//        FileWriter fileWriter = new FileWriter(file);
//        fileWriter.write("test");
//        fileWriter.flush();
//        fileWriter.close();

//        String basePath = "./templates/" + TemplateEnum.fromTemplateName(templateName).getTemplateName() + "/";
//        List<String> list = listFiles(basePath, "");
//
//        for (String fileName : list) {
//            Mustache mustache = new DefaultMustacheFactory().compile(basePath + fileName);
//
//            Map<String, Object> model = new HashMap<>();
//            model.put("package", "fewuabfwef");
//
//            String path = folderDestimation + packageName.replaceAll("\\.", "/");
//            File output = new File(path + fileName);
//            mustache.execute(new PrintWriter(output), model).flush();
//        }

        System.out.println("end");
    }
}
