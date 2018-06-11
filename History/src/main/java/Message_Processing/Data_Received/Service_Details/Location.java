
package Message_Processing.Data_Received.Service_Details;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "location",
    "gbtt_ptd",
    "gbtt_pta",
    "actual_td",
    "actual_ta",
    "late_canc_reason"
})
public class Location {

    @JsonProperty("location")
    private String location;
    @JsonProperty("gbtt_ptd")
    private String gbttPtd;
    @JsonProperty("gbtt_pta")
    private String gbttPta;
    @JsonProperty("actual_td")
    private String actualTd;
    @JsonProperty("actual_ta")
    private String actualTa;
    @JsonProperty("late_canc_reason")
    private String lateCancReason;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonCreator
    public Location(@JsonProperty("location") String location, @JsonProperty("gbtt_ptd") String gbttPtd,
                    @JsonProperty("gbtt_pta") String gbttPta, @JsonProperty("actual_td") String actualTd,
                    @JsonProperty("actual_ta") String actualTa, @JsonProperty("late_canc_reason")
                    String lateCancReason) {
        this.location = location;
        this.gbttPtd = gbttPtd;
        this.gbttPta = gbttPta;
        this.actualTd = actualTd;
        this.actualTa = actualTa;
        this.lateCancReason = lateCancReason;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "Location{" +
                "location='" + location + '\'' +
                ", gbttPtd='" + gbttPtd + '\'' +
                ", gbttPta='" + gbttPta + '\'' +
                ", actualTd='" + actualTd + '\'' +
                ", actualTa='" + actualTa + '\'' +
                ", lateCancReason='" + lateCancReason + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("gbtt_ptd")
    public String getGbttPtd() {
        return gbttPtd;
    }

    @JsonProperty("gbtt_pta")
    public String getGbttPta() {
        return gbttPta;
    }

    @JsonProperty("actual_td")
    public String getActualTd() {
        return actualTd;
    }

    @JsonProperty("actual_ta")
    public String getActualTa() {
        return actualTa;
    }

    @JsonProperty("late_canc_reason")
    public String getLateCancReason() {
        return lateCancReason;
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
