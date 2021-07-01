package com.lleclerc.service.java;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public interface ResourceUtil<T> {
    @SneakyThrows
    default InputStream getResourceAsStream(String fileName) {
        return this.getClass().getResourceAsStream(fileName);
    }

    @SneakyThrows
    default String getResourceAsString(String fileName) {
        return getResourceAsString(fileName, this.getClass());
    }

    @SneakyThrows
    static String getResourceAsString(String fileName, Class<?> rootClass) {
        InputStream inputStream = rootClass.getResourceAsStream(fileName);
        return readAndBufferAndCloseInputStreamAsString(inputStream);
    }

    @SneakyThrows
    private static String readAndBufferAndCloseInputStreamAsString(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        try (inputStream; InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            try (inputStream; reader; bufferedReader) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append(System.lineSeparator());
                }
            }
            return stringBuilder.toString();
        }
    }
}
