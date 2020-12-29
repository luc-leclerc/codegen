package com.lleclerc.codegen;

import com.arakelian.jq.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;
import net.thisptr.jackson.jq.BuiltinFunctionLoader;
import net.thisptr.jackson.jq.JsonQuery;
import net.thisptr.jackson.jq.Scope;
import net.thisptr.jackson.jq.Versions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestJq {

    @Test
    public void ff() {
        String filter = ". as $in | .history[] | . as $h |  $h + {parentDate:$in.date}";
        String json = "{\"par\": 1, \"date\": \"2014-12-30\", \"history\":[{\"id\":1, \"date\":\"2014-12-30\", \"type\":\"open\"},{\"id\":2, \"date\":\"2014-12-31\", \"type\":\"close\"}]}";

        Scope rootScope = Scope.newEmptyScope();
        BuiltinFunctionLoader.getInstance().loadFunctions(Versions.JQ_1_5, rootScope);
        Scope childScope = Scope.newChildScope(rootScope);

        JsonNode jsonNode = new ObjectMapper().rea
    }

    /**
     * https://github.com/eiiches/jackson-jq
     * https://stedolan.github.io/jq/tutorial/
     */
    @Test
    @SneakyThrows
    public void abc() {
        Scope rootScope = Scope.newEmptyScope();
        BuiltinFunctionLoader.getInstance().loadFunctions(Versions.JQ_1_5, rootScope);

        Scope childScope = Scope.newChildScope(rootScope);


        File file = new File("C:\\Users\\Luc\\git\\codegen\\src\\test\\resources\\sample.yml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        JsonNode jsonNode = new ObjectMapper(new YAMLFactory()).readValue(reader, JsonNode.class);


        final List<JsonNode> out = new ArrayList<>();
        run(".paths", jsonNode, childScope);
        System.out.println(out); // => [84]
    }

    @SneakyThrows
    public void run(String query, JsonNode jsonNode, Scope childScope) {

        final List<JsonNode> out = new ArrayList<>();
        JsonQuery.compile(query, Versions.JQ_1_5).apply(childScope, jsonNode, out::add);
        System.out.println(out);
    }
}
