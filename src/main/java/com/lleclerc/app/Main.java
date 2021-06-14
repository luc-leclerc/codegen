package com.lleclerc.app;

import lombok.SneakyThrows;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class Main extends AbstractMojo {

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

    @Override
    @SneakyThrows
    public void execute() throws MojoExecutionException, MojoFailureException {


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

    @SneakyThrows
    private void processMustache(File template) {
//        DefaultMustacheFactory defaultMustacheFactory = new DefaultMustacheFactory().compile("f")
//        Path path = Paths.get(packageDestination, fileName);
//
//        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
//            getMustache().execute(writer, scopes).flush();
//        }
    }

}
