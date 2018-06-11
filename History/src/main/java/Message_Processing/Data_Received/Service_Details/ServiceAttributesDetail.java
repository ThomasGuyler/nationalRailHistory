
package Message_Processing.Data_Received.Service_Details;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date_of_service",
    "toc_code",
    "rid",
    "locations"
})
public class ServiceAttributesDetail {

    @JsonProperty("date_of_service")
    private String dateOfService;
    @JsonProperty("toc_code")
    private String tocCode;
    @JsonProperty("rid")
    private Double rid;
    @JsonProperty("locations")
    private List<Location> locations = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonCreator
    public ServiceAttributesDetail(@JsonProperty("date_of_service") String dateOfService, @JsonProperty("toc_code")
            String tocCode, @JsonProperty("rid") Double rid, @JsonProperty("locations") List<Location> locations) {
        this.dateOfService = dateOfService;
        this.tocCode = tocCode;
        this.rid = rid;
        this.locations = locations;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "ServiceAttributesDetails{" +
                "dateOfService='" + dateOfService + '\'' +
                ", tocCode='" + tocCode + '\'' +
                ", rid=" + rid +
                ", locations=" + locations +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("date_of_service")
    public String getDateOfService() {
        return dateOfService;
    }

    @JsonProperty("toc_code")
    public String getTocCode() {
        return tocCode;
    }

    @JsonProperty("rid")
    public Double getRid() {
        return rid;
    }

    @JsonProperty("locations")
    public List<Location> getLocations() {
        return locations;
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
