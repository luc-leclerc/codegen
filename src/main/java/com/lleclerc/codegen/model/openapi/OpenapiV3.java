package com.lleclerc.codegen.model.openapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * From https://swagger.io/specification/, followed the spec to create this class.
 *
 * Notes:
 * - I didn't support every field, and used JsonNode to allow parsing without ignoring fields.
 */
@Data
public class OpenapiV3 {
    String openapi; // Required
    InfoObject info; // Required
    List<ServerObject> servers = new ArrayList<>();
    Map<String, PathItemObject> paths = new HashMap<>(); // Required
    ComponentObject components;
    List<TagObject> tags = new ArrayList<>();
    ExternalDocumentationObject externalDocs;

    @Data
    public static class InfoObject {
        String title; // Required
        String description;
        String termsOfService;
        ContactObject contact;
        LicenseObject license;
        String version;
    }

    @Data
    public static class TagObject {
        String name;
        String description;
        ExternalDocumentationObject externalDocs;
    }

    @Data
    public static class ContactObject {
        String name;
        String url;
        String email;
    }

    @Data
    public static class LicenseObject {
        String name; // Required
        String url;
    }

    @Data
    public static class ServerObject {
        String url;
        String description;
        Map<String, ServerVariableObject> variables = new HashMap<>();
    }

    @Data
    public static class PathItemObject {
        @JsonProperty("$ref")
        String ref;
        String summary;
        String description;
        OperationObject get;
        OperationObject put;
        OperationObject post;
        OperationObject delete;
        OperationObject options;
        OperationObject head;
        OperationObject patch;
        OperationObject trace;
        List<ServerObject> servers = new ArrayList<>();
        List<ParameterObject> parameters = new ArrayList<>();
    }

    @Data
    public static class OperationObject {
        List<String> tags = new ArrayList<>();
        String summary;
        String description;
        ExternalDocumentationObject externalDocs;
        String operationId;
        List<ParameterObject> parameters = new ArrayList<>();
        RequestBodyObject requestBody;
        Map<String, ResponseObject> responses = new HashMap<>();
        Map<String, CallbackObject> callbacks = new HashMap<>();
        boolean deprecated; // default false
        List<JsonNode> security = new ArrayList<>(); // Weird stuff
        List<ServerObject> servers = new ArrayList<>();
    }

    @Data
    public static class ExternalDocumentationObject {
        String description;
        String url;
    }

    @Data
    public static class ServerVariableObject {
        @JsonProperty("enum")
        List<String> enumField = new ArrayList<>();
        String defaultField; // Required
        String description;
    }

    @Data
    public static class ComponentObject {
        Map<String, SchemaObject> schemas;
        Map<String, ResponseObject> responses;
        Map<String, ParameterObject> parameters;
        Map<String, ExampleObject> examples;
        Map<String, RequestBodyObject> requestBodies;
        Map<String, HeaderObject> headers;
        Map<String, SecuritySchemeObject> securitySchemes;
        Map<String, LinkObject> links;
        Map<String, CallbackObject> callbacks;
    }

    @Data
    public static class SchemaObject extends ReferenceObject {
        // JSON schema definition
        // https://tools.ietf.org/html/draft-wright-json-schema-validation-00#page-6
        // https://tools.ietf.org/html/draft-wright-json-schema-00
        String title;
        String multipleOf; // number
        String maximum; // number
        String minimum; // number
        String maxLength; // number
        String minLength; // number
        String pattern; // regex
        String maxItems; // number
        String minItems; // number
        boolean uniqueItems;
        @JsonProperty("enum")
        List<String> enumField = new ArrayList<>();
        List<String> required = new ArrayList<>();

        // OpenAPI Specification
        String type;
        List<SchemaObject> allOf;
        List<SchemaObject> anyOf;
        SchemaObject items;
        Map<String, SchemaObject> properties;
        SchemaObject additionalProperties;
        String description;
        String format; // int32, int64, float, double, byte, binary, date, date-time, password
        @JsonProperty("default")
        String defaultField;
        String example;
        JsonNode xml;
    }

    @Data
    public static class ResponseObject extends ReferenceObject {
        String description;
        Map<String, HeaderObject> headers = new HashMap<>();
        Map<String, MediaTypeObject> content = new HashMap<>();
        Map<String, LinkObject> links = new HashMap<>();
    }

    @Data
    public static class MediaTypeObject {
        SchemaObject schema;
        String example;
    }

    @Data
    public static class ParameterObject extends ReferenceObject {
        String name;
        String in;
        String description;
        boolean required;
        boolean deprecated;
        String style;
        Boolean explode; // When style is form, the default value is true. For all other styles, the default value is false.
        SchemaObject schema;
    }

    @Data
    public static class ExampleObject extends ReferenceObject {

    }

    @Data
    public static class RequestBodyObject extends ReferenceObject {
        String description;
        Map<String, MediaTypeObject> content = new HashMap<>();
        boolean required;
    }

    @Data
    public static class HeaderObject extends ReferenceObject {
        String description;
        SchemaObject schema;
    }

    @Data
    public static class SecuritySchemeObject extends ReferenceObject {
        String type;
        String description;
        String name;
        String in;
        String scheme;
        String bearerFormat;
        JsonNode flows;
        String openIdConnectUrl;
    }

    @Data
    public static class LinkObject extends ReferenceObject {

    }

    @Data
    public static class CallbackObject extends ReferenceObject {

    }

    @Data
    public static class ReferenceObject<B> {
        @JsonProperty("$ref")
        String ref;

        boolean isRef() {
            return ref != null && !ref.isEmpty();
        }

        public B get() {
            return (B) this;
        }
    }
}
