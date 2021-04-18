package com.lleclerc.codegen.core;

import com.lleclerc.codegen.Main;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    @SneakyThrows
    public static List<String> listFiles(String basePath, String subPath) {
        List<String> result = new ArrayList<>();
        File folder = new File(Main.class.getClassLoader().getResource(basePath + "/" + subPath).toURI());

        File[] filesList = folder.listFiles();
        if (filesList == null) {
            return result;
        }
        for (File file : filesList) {
            if (file.isFile()) {
                result.add(subPath + "/" + file.getName());
            } else {
                result.addAll(listFiles(basePath, subPath + "/" + file.getName()));
            }
        }
        return result;
    }

    @SneakyThrows
    public static String readFile(String filePath) {
        return Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).collect(Collectors.joining("\n"));
    }
}
