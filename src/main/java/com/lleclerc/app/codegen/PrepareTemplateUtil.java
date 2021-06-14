package com.lleclerc.app.codegen;

import com.lleclerc.service.java.ResourceUtil;
import lombok.SneakyThrows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface PrepareTemplateUtil {


    @SneakyThrows
    static String cleanUpTemplate(String template) {
        Pattern pattern = Pattern.compile("(.*?)[^ ]*[/][*][{]{2}(.*?)[}]{2}[*][/].*?");
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String prefix = matcher.group(1);
            String mustacheKey = matcher.group(2);

            template = matcher.replaceFirst(prefix + "{{" + mustacheKey + "}}");
        }
        return template;
    }
}
