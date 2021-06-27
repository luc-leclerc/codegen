package com.lleclerc.app.codegen.java.template/*{{{packageName}}}*/;

import lombok.Getter;

// Generated on {{{now}}}
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
