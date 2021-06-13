// @formatter:off
package com.lleclerc.app.codegen.template/*{{{packageName}}}*/;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ModelClass/*{{{className}}}*/ {
  /*{{#properties}}*/
    @JsonProperty("{{{propertyName}}}")
    String/*{{{type}}}*/ nameNotReserved/*{{{propertySafeName}}}*/ = null/*{{{defaultValue}}}*/;
  /*{{/properties}}*/
}
// @formatter:on