
package Message_Processing.Data_Received.Service_Metrics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "origin_location",
    "destination_location",
    "gbtt_ptd",
    "gbtt_pta",
    "toc_code",
    "matched_services",
    "rids"
})
public class ServiceAttributesMetrics {

    @JsonProperty("origin_location")
    private String originLocation;
    @JsonProperty("destination_location")
    private String destinationLocation;
    @JsonProperty("gbtt_ptd")
    private String gbttPtd;
    @JsonProperty("gbtt_pta")
    private String gbttPta;
    @JsonProperty("toc_code")
    private String tocCode;
    @JsonProperty("matched_services")
    private Integer matchedServices;
    @JsonProperty("rids")
    private List<Long> rids = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonCreator
    public ServiceAttributesMetrics(
            @JsonProperty("origin_location") String originLocation, @JsonProperty("destination_location")
            String destinationLocation, @JsonProperty("gbtt_ptd") String gbttPtd, @JsonProperty("gbtt_pta")
            String gbttPta, @JsonProperty("toc_code") String tocCode, @JsonProperty("matched_services")
            Integer matchedServices, @JsonProperty("rids") List<Long> rids) {

        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.gbttPtd = gbttPtd;
        this.gbttPta = gbttPta;
        this.tocCode = tocCode;
        this.matchedServices = matchedServices;
        this.rids = rids;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "ServiceAttributesMetrics{" +
                "originLocation='" + originLocation + '\'' +
                ", destinationLocation='" + destinationLocation + '\'' +
                ", gbttPtd='" + gbttPtd + '\'' +
                ", gbttPta='" + gbttPta + '\'' +
                ", tocCode='" + tocCode + '\'' +
                ", matchedServices=" + matchedServices +
                ", rids=" + rids +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("origin_location")
    public String getOriginLocation() {
        return originLocation;
    }

    @JsonProperty("destination_location")
    public String getDestinationLocation() {
        return destinationLocation;
    }

    @JsonProperty("gbtt_ptd")
    public String getGbttPtd() {
        return gbttPtd;
    }

    @JsonProperty("gbtt_pta")
    public String getGbttPta() {
        return gbttPta;
    }

    @JsonProperty("toc_code")
    public String getTocCode() {
        return tocCode;
    }

    @JsonProperty("matched_services")
    public Integer getMatchedServices() {
        return matchedServices;
    }

    @JsonProperty("rids")
    public List<Long> getRids() {
        return rids;
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
