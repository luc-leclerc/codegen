package com.lleclerc.service.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public interface MustacheUtil {
    DefaultMustacheFactory MUSTACHE_FACTORY = new DefaultMustacheFactory();

    @SneakyThrows
    static void compileToFile(String mustacheTemplate, Path destFolder, String destFileName, Object model) {
        FileWriter fileWriter = new FileWriter(new File(destFolder.toString(), destFileName), StandardCharsets.UTF_8);
        compile(new StringReader(mustacheTemplate), fileWriter, model);
    }

    @SneakyThrows
    static String compile(String mustacheTemplate, Object model) {
        StringWriter stringWriter = new StringWriter();
        compile(new StringReader(mustacheTemplate), stringWriter, model);
        return stringWriter.toString();
    }

    @SneakyThrows
    static void compile(Reader templateReader, Writer compiledWriter, Object model) {
        Mustache mustache = MUSTACHE_FACTORY.compile(templateReader, "dummyName");
        mustache.execute(compiledWriter, model).flush();
    }
}
