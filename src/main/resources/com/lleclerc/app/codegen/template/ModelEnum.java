package com.lleclerc.app.codegen.template/*{{{packageName}}}*/;

import lombok.Getter;

@Getter
public enum ModelEnum/*enumName*/ {
    /*{{#elements}}*/
    SAFE_ENUM_NAME/*{{{name_safeJava}}}*/("{{{name}}}");
    /*{{/elements}}*/

    private final String value;

    ModelEnum(String value) {
        this.value = value;
    }
}
