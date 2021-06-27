package com.lleclerc.service.java;

import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("ConstantConditions") // This fix `.toURI()` warning.
public interface ResourceUtil<T> {
    @SneakyThrows
    default InputStream readResource(String fileName) {
        File file = new File(this.getClass().getResource(fileName).toURI());
        return new BufferedInputStream(new FileInputStream(file));
    }

    @SneakyThrows
    default String readResourceAsString(String fileName) {
        return readResourceAsString(fileName, this.getClass());
    }

    @SneakyThrows
    static String readResourceAsString(String fileName, Class<?> rootClass) {
        Path path = Paths.get(rootClass.getResource(fileName).toURI());
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    static String readJavaResourceFromClass(Class<?> classToFindJava) {
        return readResourceAsString(classToFindJava.getSimpleName() + ".java", classToFindJava);
    }
}
