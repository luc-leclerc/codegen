package com.lleclerc.codegen.core;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import lombok.SneakyThrows;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lleclerc.codegen.core.FileUtils.listFiles;

public class MustacheCompilerService {

    final DefaultMustacheFactory mustacheFactory = new DefaultMustacheFactory();

    @SneakyThrows
    public static String compileStandalone(String template, Map<String, Object> model) {
        DefaultMustacheFactory mustacheFactory = new DefaultMustacheFactory();
        StringWriter writer = new StringWriter();
        Mustache mustache = mustacheFactory.compile(new StringReader(template), "dummyName");
        mustache.execute(writer, model).flush();
        return writer.toString();
    }



    @SneakyThrows
    public void execute(String sourceTemplatePath, String destinationCompiledPath) {
        List<String> list = listFiles(sourceTemplatePath, "");

        for (String fileName : list) {
            Mustache mustache = mustacheFactory.compile(fileName);

            Map<String, Object> model = new HashMap<>();
            model.put("package", "fewuabfwef");

            String subPath = fileName.substring(sourceTemplatePath.length());
            model.put("javaPackageName", subPath.replaceAll(File.separator, "."));

            File output = new File(destinationCompiledPath, subPath);
            mustache.execute(new PrintWriter(output), model).flush();
        }
    }
}
