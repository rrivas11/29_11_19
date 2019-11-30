
package com.example.math.pojos.svc;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "infix"
})
public class ResquestPostfix {

    @JsonProperty("exp")
    private String exp;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("exp")
    public String getInfix() {
        return exp;
    }

    @JsonProperty("exp")
    public void setInfix(String exp) {
        this.exp = exp;
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
