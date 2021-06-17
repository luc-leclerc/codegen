package com.lleclerc.service.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import lombok.SneakyThrows;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public interface MustacheUtil {
    DefaultMustacheFactory MUSTACHE_FACTORY = new DefaultMustacheFactory();

    @SneakyThrows
    static String compile(String mustacheTemplate, Object model) {
        StringWriter stringWriter = new StringWriter();
        compile(new StringReader(mustacheTemplate), stringWriter, model);
        return stringWriter.toString();
    }

    @SneakyThrows
    static void compile(String mustacheTemplate, Object model, Writer writer) {
        compile(new StringReader(mustacheTemplate), writer, model);
    }

    @SneakyThrows
    static void compile(Reader templateReader, Writer compiledWriter, Object model) {
        Mustache mustache = MUSTACHE_FACTORY.compile(templateReader, "dummyName");
        mustache.execute(compiledWriter, model).flush();
    }
}
