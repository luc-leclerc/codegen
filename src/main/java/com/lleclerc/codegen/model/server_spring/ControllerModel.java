package com.lleclerc.codegen.model.server_spring;

import lombok.Data;

import java.util.List;

@Data
public class ControllerModel {
    private List<Operation> operations;

    @Data
    public static class Operation {
        private String operationId;
    }
}
