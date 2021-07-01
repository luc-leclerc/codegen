package com.lleclerc.app.codegen.java;

import com.lleclerc.app.codegen.java.model.JavaClass;
import com.lleclerc.app.codegen.java.model.JavaClassProperty;
import com.lleclerc.app.codegen.java.model.JavaEnum;
import com.lleclerc.app.codegen.java.model.JavaEnumElement;
import com.lleclerc.app.codegen.java.template.ModelClass;
import com.lleclerc.app.codegen.java.template.ModelEnum;
import com.lleclerc.app.codegen.util.JavaNameMap;
import com.lleclerc.service.java.IoUtil;
import com.lleclerc.service.java.PatternUtil;
import com.lleclerc.service.java.ResourceUtil;
import com.lleclerc.service.mustache.MustacheUtil;
import com.lleclerc.service.swagger.OpenapiV3Model;
import com.lleclerc.service.yml.jackson.JacksonImplYamlUtil;
import lombok.SneakyThrows;

import java.io.File;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.regex.Pattern;

public class JavaCodeGenUtil {
    // Prepare mustache template, ex.: `my test/*{{myTag}}*/` -> `my {{myTag}}`
    static Pattern PATTERN_CLEAN_TEMPLATE = Pattern.compile("(.*?)[^ ]*[/][*][{]{2}(.*?)[}]{2}[*][/].*?");

    static String MODEL_CLASS_TEMPLATE = cleanUpTemplate(ResourceUtil.getResourceAsString(ModelClass.class.getSimpleName() + ".java", ModelClass.class));
    static String MODEL_ENUM_TEMPLATE = cleanUpTemplate(ResourceUtil.getResourceAsString(ModelEnum.class.getSimpleName() + ".java", ModelEnum.class));

    public static void executeJava(String yamlFilePath, String destinationPath, String basePackage) {
        InputStream inputStream = IoUtil.toBufferedInputStream(Path.of(yamlFilePath));
        OpenapiV3Model openapiV3Model = JacksonImplYamlUtil.parseInputStream(inputStream, OpenapiV3Model.class);

        executeJavaModel(openapiV3Model, destinationPath, basePackage);

//        executeJavaController();
    }

    private static void executeJavaModel(OpenapiV3Model openapiV3Model, String destinationPath, String basePackage) {
        for (Map.Entry<String, OpenapiV3Model.SchemaObject> modelEntry : openapiV3Model.getComponents().getSchemas().entrySet()) {
            OpenapiV3Model.SchemaObject model = modelEntry.getValue();
            String modelName = PatternUtil.toJavaModelName(modelEntry.getKey());
            String modelPackage = basePackage + ".model";

            Path destination = Path.of(destinationPath, modelPackage.replaceAll("\\.", File.separator), modelName + ".java");
            Writer destinationWriter = IoUtil.toWriter(destination);

            // Java Class
            if ("object".equals(model.getType())) {
                JavaClass.JavaClassBuilder classBuilder = JavaClass.builder();
                classBuilder.className(modelName);
                classBuilder.packageName(modelPackage);
                for (Map.Entry<String, OpenapiV3Model.SchemaObject> propertyEntry : model.getProperties().entrySet()) {
                    OpenapiV3Model.SchemaObject property = propertyEntry.getValue();
                    JavaClassProperty javaProperty = JavaClassProperty.builder()
                            .propertyName(PatternUtil.toCamelCaseWithLettersOnly(propertyEntry.getKey()))
                            .type(getJavaType(property)).build();
                    classBuilder.property(javaProperty);
                }
                JavaClass javaClass = classBuilder.build();
                MustacheUtil.compile(MODEL_CLASS_TEMPLATE, new JavaNameMap(javaClass), destinationWriter);
                continue;
            }

            // Java Enum
            if ("string".equals(model.getType()) && model.getEnumField() != null && !model.getEnumField().isEmpty()) {
                JavaEnum.JavaEnumBuilder enumBuilder = JavaEnum.builder();
                enumBuilder.enumName(modelName);
                enumBuilder.packageName(modelPackage);
                model.getEnumField().forEach(enumValue -> enumBuilder.element(JavaEnumElement.builder().name(enumValue).build()));
                JavaEnum javaEnum = enumBuilder.build();
                MustacheUtil.compile(MODEL_ENUM_TEMPLATE, new JavaNameMap(javaEnum), destinationWriter);
            }
            throw new RuntimeException("Unexpected schema");
        }
    }

    @SneakyThrows
    static String cleanUpTemplate(String template) {
        return PATTERN_CLEAN_TEMPLATE.matcher(template).replaceAll("$1{{$2}}");
    }

    static String getJavaType(OpenapiV3Model.SchemaObject property) {
        String openApiRef = property.getRef();
        String openApiType = property.getType();
        String openApiFormat = property.getFormat();

        if (openApiRef != null && !openApiRef.isBlank()) {
            return openApiRef.substring(openApiRef.lastIndexOf("/") + 1);
        }
        if ("boolean".equals(openApiType))
            return Boolean.class.getSimpleName();

        if ("integer".equals(openApiType)) {
            if ("int64".equals(openApiFormat))
                return Long.class.getSimpleName();
            return Integer.class.getSimpleName();
        }

        if ("number".equals(openApiType)) {
            if ("float".equals(openApiFormat))
                return Float.class.getSimpleName();
            if ("double".equals(openApiFormat))
                return Double.class.getSimpleName();
            return BigDecimal.class.getSimpleName();
        }

        if ("string".equals(openApiType)) {
            if ("date".equals(openApiFormat))
                return LocalDate.class.getSimpleName();
            if ("date-time".equals(openApiFormat))
                return LocalDateTime.class.getSimpleName();
            return String.class.getSimpleName();
        }

        if ("array".equals(openApiType)) {
            return "List<" + getJavaType(property.getItems()) + ">";
        }

        throw new RuntimeException(String.format("Unexpected format: ref %s, type %s, format %s", openApiRef, openApiType, openApiFormat));
    }
}
