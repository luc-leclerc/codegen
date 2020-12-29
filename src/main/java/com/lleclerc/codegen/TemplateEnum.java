package com.lleclerc.codegen;

import lombok.Getter;

public enum TemplateEnum {
    CLIENT_SPRING("client_spring"),
    SERVER_SPRING("server_spring");

    @Getter
    private String templateName;

    TemplateEnum(String name) {
        this.templateName = name;
    }

    static TemplateEnum fromTemplateName(String templateName) {
        for (int i = 0; i < TemplateEnum.values().length; i++) {
            TemplateEnum currentEnum = TemplateEnum.values()[i];
            if (currentEnum.getTemplateName().equalsIgnoreCase(templateName)) {
                return currentEnum;
            }
        }
        throw new IllegalStateException("Did not find template: " + templateName);
    }
}
