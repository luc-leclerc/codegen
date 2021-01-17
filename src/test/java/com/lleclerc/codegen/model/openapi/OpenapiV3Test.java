package com.lleclerc.codegen.model.openapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.InputStream;

public class OpenapiV3Test {

    final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    final InputStream sampleYaml = OpenapiV3Test.class.getClassLoader().getResourceAsStream("sample.yml");

    @Test
    @SneakyThrows
    public void serializeAndDeserialize_works() {
//        JsonNode node = objectMapper.readValue(sampleYaml, JsonNode.class);
        OpenapiV3 openapiV3 = objectMapper.readValue(sampleYaml, OpenapiV3.class);

        System.out.println("s");
    }
}