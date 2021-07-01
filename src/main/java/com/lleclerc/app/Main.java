package com.lleclerc.app;

import com.lleclerc.app.codegen.java.JavaCodeGenUtil;

public class Main {

    private static final String BASE_PACKAGE = "base.package";
    private static final String DESTINATION_PATH = "destination.path";
    private static final String YAML_FILE_PATH = "yml.file.path";

    public static void main(String[] args) {
        String basePackage = System.getProperty(BASE_PACKAGE);
        String destinationPath = System.getProperty(DESTINATION_PATH);
        String yamlFilePath = System.getProperty(YAML_FILE_PATH);

        JavaCodeGenUtil.executeJava(yamlFilePath, destinationPath, basePackage);
        System.out.println("Codegen completed.");
    }
}
