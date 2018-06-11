
package Message_Processing.Data_Received.Service_Metrics;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tolerance_value",
    "num_not_tolerance",
    "num_tolerance",
    "percent_tolerance",
    "global_tolerance"
})
public class Metrics {

    @JsonProperty("tolerance_value")
    private Integer toleranceValue;
    @JsonProperty("num_not_tolerance")
    private Integer numNotTolerance;
    @JsonProperty("num_tolerance")
    private Integer numTolerance;
    @JsonProperty("percent_tolerance")
    private Integer percentTolerance;
    @JsonProperty("global_tolerance")
    private boolean globalTolerance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonCreator
    public Metrics(
            @JsonProperty("tolerance_value") Integer toleranceValue, @JsonProperty("num_not_tolerance")
            Integer numNotTolerance, @JsonProperty("num_tolerance") Integer numTolerance,
            @JsonProperty("percent_tolerance") Integer percentTolerance, @JsonProperty("global_tolerance")
            boolean globalTolerance) {

        this.toleranceValue = toleranceValue;
        this.numNotTolerance = numNotTolerance;
        this.numTolerance = numTolerance;
        this.percentTolerance = percentTolerance;
        this.globalTolerance = globalTolerance;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "Metrics{" +
                "toleranceValue=" + toleranceValue +
                ", numNotTolerance=" + numNotTolerance +
                ", numTolerance=" + numTolerance +
                ", percentTolerance=" + percentTolerance +
                ", globalTolerance=" + globalTolerance +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("tolerance_value")
    public Integer getToleranceValue() {
        return toleranceValue;
    }

    @JsonProperty("num_not_tolerance")
    public Integer getNumNotTolerance() {
        return numNotTolerance;
    }

    @JsonProperty("num_tolerance")
    public Integer getNumTolerance() {
        return numTolerance;
    }

    @JsonProperty("percent_tolerance")
    public Integer getPercentTolerance() {
        return percentTolerance;
    }

    @JsonProperty("global_tolerance")
    public boolean isGlobalTolerance() {
        return globalTolerance;
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
