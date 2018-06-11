
package Message_Processing.Data_Received.Service_Metrics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Message_Processing.Data_Request.ServiceMetricRequest;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Services"
})
public class Services {

    @JsonProperty("Services")
    private List<Service> services = null;
    //Want to keep details of the request associated with Services
    @JsonIgnore
    private ServiceMetricRequest serviceMetricRequest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonCreator
    public Services(@JsonProperty("Services") List<Service> services) {
        this.services = services;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "Services{" +
                "services=" + services +
                ", additionalProperties=" + additionalProperties +
                ", serviceMetricRequest=" + serviceMetricRequest +
                '}';
    }

    @JsonIgnore
    public ServiceMetricRequest getServiceMetricRequest() { return serviceMetricRequest; }

    @JsonIgnore
    public void setServiceMetricRequest(ServiceMetricRequest serviceMetricRequest) {
        this.serviceMetricRequest = serviceMetricRequest;
    }

    @JsonProperty("Services")
    public List<Service> getServices() {
        return services;
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
