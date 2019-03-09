
package com.wth.testapp.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "watchId",
    "date",
    "values"
})
public class Regeneration {

    @JsonProperty("watchId")
    private Integer watchId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("values")
    private List<Integer> values = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("watchId")
    public Integer getWatchId() {
        return watchId;
    }

    @JsonProperty("watchId")
    public void setWatchId(Integer watchId) {
        this.watchId = watchId;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("values")
    public List<Integer> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<Integer> values) {
        this.values = values;
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
