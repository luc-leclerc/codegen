package com.lleclerc.app.codegen;

import com.lleclerc.app.codegen.model.ModelScope;
import com.lleclerc.app.codegen.template.ModelClass;
import com.lleclerc.service.mustache.MustacheUtil;
import com.lleclerc.service.swagger.OpenapiV3Model;
import lombok.SneakyThrows;

import java.nio.file.Path;
import java.util.Map;

public interface CodeGenUtil {

    @SneakyThrows
//    @SuppressWarnings("ResultOfMethodCallIgnored")
    static void compileModels(OpenapiV3Model model, Path destination) {

//        for (Map.Entry<String, OpenapiV3Model.SchemaObject> entry : model.getComponents().getSchemas().entrySet()) {
////            if (entry.getValue().getType())
//        }

//        model.getComponents().getSchemas()
//        file.getParentFile().mkdirs();
//        List<String> list = listFiles(sourceTemplatePath, "");
//        for (String fileName : list) {
//            Mustache mustache = MUSTACHE_FACTORY.compile(fileName);
//
//            Map<String, Object> model = new HashMap<>();
//            model.put("package", "fewuabfwef");
//
//            String subPath = fileName.substring(sourceTemplatePath.length());
//            model.put("javaPackageName", subPath.replaceAll(File.separator, "."));
//
//            File output = new File(destinationCompiledPath, subPath);
//            mustache.execute(new PrintWriter(output), model).flush();
//        }
    }

    static void compileModel(Object model, Path destination) {

//        MustacheUtil.compile();
    }
}
