package com.lleclerc.service.java;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//@SuppressWarnings("ConstantConditions") // This fix `.toURI()` warning.
public interface ResourceUtil {
    @SneakyThrows
    default InputStream readResource(String fileName) {
        File file = new File(this.getClass().getResource(fileName).toURI());
        return new BufferedInputStream(new FileInputStream(file));
    }

    @SneakyThrows
    default Reader readResourceAsBufferedReader(String fileName) {
        Path path = Paths.get(this.getClass().getResource(fileName).toURI());
        return Files.newBufferedReader(path, StandardCharsets.UTF_8);
    }

    @SneakyThrows
    default String readResourceAsString(String fileName) {
        Path path = Paths.get(this.getClass().getResource(fileName).toURI());
        return Files.readString(path, StandardCharsets.UTF_8);
    }
}
