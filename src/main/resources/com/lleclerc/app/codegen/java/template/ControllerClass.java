package com.lleclerc.app.codegen.java.template;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class ControllerClass/*{{{className}}}*/ {
    /*{{#operations}}*/
//    @RequestMapping(method = {RequestMethod.GET/*{{{httpMethod}}}*/})
//    public ResponseEntity<Object> operationId/*{{{operationId}}}*/( /**/@RequestParam/**/ String abc) {
//        throw new UnsupportedOperationException();
//    }
    /*{{/operations}}*/
}
