import Message_Processing.Data_Received.Service_Details.ServiceAttributesDetails;
import Message_Processing.Data_Received.Service_Metrics.Services;
import Message_Processing.Data_Request.ServiceDetailsRequest;
import Message_Processing.Data_Request.ServiceMetricRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Test {

    public static Boolean loginTest (){

        Boolean success = false;

        ServiceMetricRequest metricRequest = ServiceMetricRequest.valueOf("CLJ", "LHD", "0700",
                "0800", "2018-03-01", "2018-05-01", "WEEKDAY", List.of("SW", "HW"),
                List.of("2", "5", "10"));

        ServiceMetricRequest metricRequest2 = ServiceMetricRequest.valueOf("CLJ", "LHD", "0500",
                "0800", "2017-08-15", "2017-08-15", "WEEKDAY", List.of("SW", "HW"),
                List.of("0", "30", "30"));

        ResponseEntity<Services> response2 = metricRequest2.handleRequest();

        ServiceDetailsRequest detailRequest = ServiceDetailsRequest.valueOf(201607294212242L);
        ServiceDetailsRequest detailRequest2 = ServiceDetailsRequest.valueOf(201708158735486L);

        ResponseEntity<ServiceAttributesDetails> detailsResponse2 = detailRequest2.handleRequest();

        ResponseEntity<Services> response = metricRequest.handleRequest();
        ResponseEntity<ServiceAttributesDetails> detailsResponse = detailRequest.handleRequest();

        try {
            System.out.println(response.getBody().getServices().get(0).getMetrics().toString());
        } catch (Exception ex)
        {
            System.out.println(ex);
        }
        try {
            System.out.println(detailsResponse.getBody().toString());
        } catch (Exception ex)
        {
            System.out.println(ex);
        }

        if (response.getBody().getServices().get(0).getMetrics().get(0).getNumTolerance() == 20) {
            success = true;
        }

        return success;
    }
}