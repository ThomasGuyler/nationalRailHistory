package Business_Logic.Train_Details;

import Message_Processing.Data_Received.Service_Metrics.Services;
import Message_Processing.Data_Request.ServiceMetricRequest;
import org.springframework.http.ResponseEntity;

public class LateTrainRequests {

    private final ResponseEntity<Services> services;
    public Integer lateSpecificationTime;

    public LateTrainRequests(String fromLoc, String toLoc, String fromTime, String toTime, String fromDate,
                             String toDate, String days, Integer lateSpecificationTime) {

        ServiceMetricRequest metricRequest = ServiceMetricRequest.valueOf(fromLoc, toLoc, fromTime, toTime, fromDate,
                toDate, days, null, null);
        services = metricRequest.handleRequest();
        this.lateSpecificationTime = lateSpecificationTime;
    }


}
