
package Message_Processing.Data_Received.Service_Metrics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "serviceAttributesMetrics",
    "Metrics"
})
public class Service {

    @JsonProperty("serviceAttributesMetrics")
    private ServiceAttributesMetrics serviceAttributesMetrics;
    @JsonProperty("Metrics")
    private List<Metrics> metrics = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonCreator
    public Service(@JsonProperty("serviceAttributesMetrics") ServiceAttributesMetrics serviceAttributesMetrics,
                   @JsonProperty("Metrics") List<Metrics> metrics) {

        this.serviceAttributesMetrics = serviceAttributesMetrics;
        this.metrics = metrics;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "Service{" +
                "serviceAttributesMetrics=" + serviceAttributesMetrics +
                ", Metrics=" + metrics +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("serviceAttributesMetrics")
    public ServiceAttributesMetrics getServiceAttributesMetrics() {
        return serviceAttributesMetrics;
    }

    @JsonProperty("Metrics")
    public List<Metrics> getMetrics() {
        return metrics;
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
