package com.lleclerc.service.java;

import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public interface IoUtil {
    @SneakyThrows
    static Writer toWriter(Path path) {
        path.toFile().getParentFile().mkdirs();
        return Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    static InputStream toInputStream(String value) {
        return new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
    }

    @SneakyThrows
    static BufferedInputStream toBufferedInputStream(Path path) {
        return new BufferedInputStream(Files.newInputStream(path));
    }
}
