package com.lleclerc.app.codegen;

import com.lleclerc.app.codegen.template.ModelClass;
import com.lleclerc.service.java.ResourceUtil;
import com.lleclerc.service.mustache.MustacheUtil;
import lombok.SneakyThrows;

import java.io.Writer;
import java.util.regex.Pattern;

public interface CodeGenUtil extends ResourceUtil {
    Pattern PATTERN_CLEAN_TEMPLATE = Pattern.compile("(.*?)[^ ]*[/][*][{]{2}(.*?)[}]{2}[*][/].*?");

    static void compileModelToWriter(Object model, Writer writer) {
        String resourcePath = "./template/" + ModelClass.class.getSimpleName() + ".java";
        String rawTemplate = ResourceUtil.readResourceAsString(resourcePath, CodeGenUtil.class);
        String template = cleanUpTemplate(rawTemplate);

        MustacheUtil.compile(template, model, writer);
    }

    @SneakyThrows
    static String cleanUpTemplate(String template) {
        return PATTERN_CLEAN_TEMPLATE.matcher(template).replaceAll("$1{{$2}}");
    }
}
