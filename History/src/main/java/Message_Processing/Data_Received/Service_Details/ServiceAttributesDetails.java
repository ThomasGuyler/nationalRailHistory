package Message_Processing.Data_Received.Service_Details;

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
        "serviceAttributesDetails"
})
public class ServiceAttributesDetails {

    @JsonProperty("serviceAttributesDetails")
    private ServiceAttributesDetail serviceAttributesDetail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("serviceAttributesDetails")
    public ServiceAttributesDetail getServiceAttributesDetail() {
        return serviceAttributesDetail;
    }

    @JsonProperty("serviceAttributesDetails")
    public void setServiceAttributesDetails(ServiceAttributesDetail serviceAttributesDetail) {
        this.serviceAttributesDetail = serviceAttributesDetail;
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
