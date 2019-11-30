
package com.example.math.pojos.svc;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "infix",
    "postfix",
    "result"
})
public class ResponsePostfix {

    @JsonProperty("infix")
    private String infix;
    @JsonProperty("postfix")
    private String postfix;
    @JsonProperty("message")
    private String message;
    @JsonProperty("result")
    private Integer result;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("infix")
    public String getInfix() {
        return infix;
    }

    @JsonProperty("infix")
    public void setInfix(String infix) {
        this.infix = infix;
    }

    @JsonProperty("postfix")
    public String getPostfix() {
        return postfix;
    }

    @JsonProperty("postfix")
    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    @JsonProperty("result")
    public Integer getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
