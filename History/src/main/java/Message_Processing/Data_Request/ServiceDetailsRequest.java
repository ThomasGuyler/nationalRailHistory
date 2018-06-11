
package Message_Processing.Data_Request;

import java.util.HashMap;
import java.util.Map;

import Message_Processing.Data_Received.Service_Details.ServiceAttributesDetails;
import Message_Processing.HTTP_Utilities;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rid"
})
public class ServiceDetailsRequest {

    @JsonProperty("rid")
    private Long rid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnore
    private ServiceDetailsRequest (Long rid){
        this.rid = rid;
    }

    @JsonIgnore
    public static ServiceDetailsRequest valueOf(Long rid){
        ServiceDetailsRequest request = new ServiceDetailsRequest(rid);
        return request;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "ServiceDetailsRequest{" +
                "rid=" + rid +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("rid")
    public Long getRid() {
        return rid;
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
    public ResponseEntity<ServiceAttributesDetails> handleRequest(){

        HttpEntity<ServiceDetailsRequest> requestEntity = new HttpEntity<>(
                this, HTTP_Utilities.setAuthorizationHeader());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ServiceAttributesDetails> response = restTemplate.exchange
                (HTTP_Utilities.uriDetails, HttpMethod.POST, requestEntity, ServiceAttributesDetails.class);

        return response;
    }

}
