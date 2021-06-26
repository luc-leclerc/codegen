package com.lleclerc.service.java;

import java.util.regex.Pattern;

public interface PatternUtil {
    Pattern TO_CAMEL_CASE = Pattern.compile("[-_]+([a-z]?)");
    Pattern TO_LETTERS = Pattern.compile("[^a-zA-Z]");

    static String toSafeJavaName(String value) {
        String caseAlternate = TO_CAMEL_CASE.matcher(value).replaceAll(matchResult -> matchResult.group(1).toUpperCase());
        return TO_LETTERS.matcher(caseAlternate).replaceAll("");
    }
}
