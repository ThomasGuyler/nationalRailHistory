
package Message_Processing.Data_Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Message_Processing.Data_Received.Service_Metrics.Services;
import Message_Processing.HTTP_Utilities;
import com.fasterxml.jackson.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "from_loc",
        "to_loc",
        "from_time",
        "to_time",
        "from_date",
        "to_date",
        "days",
        "toc_filter",
        "tolerance"
})
public class ServiceMetricRequest {

    @JsonProperty("from_loc")
    private final String fromLoc;
    @JsonProperty("to_loc")
    private final String toLoc;
    @JsonProperty("from_time")
    private final String fromTime;
    @JsonProperty("to_time")
    private final String toTime;
    @JsonProperty("from_date")
    private final String fromDate;
    @JsonProperty("to_date")
    private final String toDate;
    @JsonProperty("days")
    private final String days;

    @JsonProperty("toc_filter")
    @JsonPropertyDescription("Optional: A list of TOC (Train Operating Companies) codes to filter the train companies" +
            " returned. TOC codes are all two letters i.e South Western Railway = HY")
    private final List<String> tocfilter;

    @JsonProperty("tolerance")
    @JsonPropertyDescription("Optional: set of up to three values to set additional tolerances for the Metrics. A " +
            "tolerance of 0 is always included by default. For Example,['2', '5', '10'] will return statistics for " +
            "the number of trains which arrived at the to_loc within 0 minutes, 2 minutes, within 5 minutes and " +
            "within 10 minutes of their scheduled time")
    private final List<String> tolerance;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnore
    private ServiceMetricRequest(
            String fromLoc, String toLoc, String fromTime, String toTime, String fromDate, String toDate, String days,
            List<String> tocfilter, List<String> tolerance) {

        this.fromLoc = fromLoc;
        this.toLoc = toLoc;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.days = days;
        this.tocfilter = tocfilter;
        this.tolerance = tolerance;
    }

    @JsonIgnore
    public static ServiceMetricRequest valueOf(
            String fromLoc, String toLoc, String fromTime, String toTime, String fromDate, String toDate, String days,
            List<String> tocfilter, List<String> tolerance) {

        ServiceMetricRequest request = new ServiceMetricRequest(
                fromLoc, toLoc, fromTime, toTime, fromDate, toDate, days, tocfilter, tolerance);

        return request;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "ServiceMetricRequest{" +
                "fromLoc='" + fromLoc + '\'' +
                ", toLoc='" + toLoc + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", days='" + days + '\'' +
                ", toc_filter='" + tocfilter + '\'' +
                ", tolerance ='" + tolerance + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("from_loc")
    public String getFromLoc() {
        return fromLoc;
    }

    @JsonProperty("to_loc")
    public String getToLoc() {
        return toLoc;
    }

    @JsonProperty("from_time")
    public String getFromTime() {
        return fromTime;
    }

    @JsonProperty("to_time")
    public String getToTime() {
        return toTime;
    }

    @JsonProperty("from_date")
    public String getFromDate() {
        return fromDate;
    }

    @JsonProperty("to_date")
    public String getToDate() {
        return toDate;
    }

    @JsonProperty("days")
    public String getDays() {
        return days;
    }

    @JsonProperty("toc_filter")
    public List<String> getTocFilter() {
        return tocfilter;
    }

    @JsonProperty("tolerance")
    public List<String> getTolerance() {
        return tolerance;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonIgnore
    public ResponseEntity<Services> handleRequest(){

        HttpEntity<ServiceMetricRequest> requestEntity = new HttpEntity<>(
                this, HTTP_Utilities.setAuthorizationHeader());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Services> response = restTemplate.exchange
                (HTTP_Utilities.uriMetrics, HttpMethod.POST, requestEntity, Services.class);

        //Important information about the response is only in the request, so request is stored in response
        response.getBody().setServiceMetricRequest(this);

        return response;
    }

}
