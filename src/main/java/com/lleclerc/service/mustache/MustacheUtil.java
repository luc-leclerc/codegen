package com.lleclerc.service.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public interface MustacheUtil {
    DefaultMustacheFactory MUSTACHE_FACTORY = new DefaultMustacheFactory();

    @SneakyThrows
    static void compileToFile(Path mustacheTemplate, Path destFolder, String destFileName, Map<String, Object> model) {
        Reader templateReader = Files.newBufferedReader(mustacheTemplate, StandardCharsets.UTF_8);
        FileWriter fileWriter = new FileWriter(new File(destFolder.toString(), destFileName), StandardCharsets.UTF_8);
        compile(templateReader, fileWriter, model);
    }

    @SneakyThrows
    static String compile(String mustacheTemplate, Map<String, Object> model) {
        StringWriter stringWriter = new StringWriter();
        compile(new StringReader(mustacheTemplate), stringWriter, model);
        return stringWriter.toString();
    }

    @SneakyThrows
    static void compile(Reader templateReader, Writer compiledWriter, Map<String, Object> model) {
        Mustache mustache = MUSTACHE_FACTORY.compile(templateReader, "dummyName");
        mustache.execute(compiledWriter, model).flush();
    }
}
