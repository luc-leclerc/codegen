package com.lleclerc.app.codegen;

import com.lleclerc.service.java.ResourceUtil;
import com.lleclerc.service.mustache.MustacheUtil;
import lombok.SneakyThrows;

import java.nio.file.Path;
import java.util.regex.Pattern;

public interface CodeGenUtil extends ResourceUtil {
    Pattern PATTERN_CLEAN_TEMPLATE = Pattern.compile("(.*?)[^ ]*[/][*][{]{2}(.*?)[}]{2}[*][/].*?");

    static void compileModelToFile(Path destination, String filename, Object model) {
        String rawTemplate = ResourceUtil.readResourceAsString("./template/ModelClass.java", CodeGenUtil.class);
        String template = cleanUpTemplate(rawTemplate);

        MustacheUtil.compileToFile(template, destination, filename, model);
    }

    @SneakyThrows
    static String cleanUpTemplate(String template) {
        return PATTERN_CLEAN_TEMPLATE.matcher(template).replaceAll("$1{{$2}}");
    }
}
