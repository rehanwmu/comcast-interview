package com.comcast.interview.consumer;

import com.comcast.interview.consumer.model.BloodPressure;
import com.comcast.interview.consumer.model.MedicalRecord;
import com.comcast.interview.consumer.model.RestPageImpl;
import com.comcast.interview.consumer.util.Utility;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final String URL = "https://jsonmock.hackerrank.com/api/medical_records";
    private RestTemplate restTemplate = new RestTemplate();

    public BloodPressure getData() {
        String doctorName = "Dr Arnold Bullock";
        Integer diagnosisId = 3;


        ParameterizedTypeReference<RestPageImpl<MedicalRecord>> responseType =
                new ParameterizedTypeReference<RestPageImpl<MedicalRecord>>() {
                };
        ResponseEntity<RestPageImpl<MedicalRecord>> result = restTemplate.
                exchange(URL, HttpMethod.GET, null,
                        responseType);
        List<MedicalRecord> medicalRecords = result.getBody().getContent();
        BloodPressure bloodPressure = Utility.findBloodPressure(medicalRecords, diagnosisId, doctorName);
        if (null != bloodPressure.getLow() && null != bloodPressure.getHigh())
            return bloodPressure;
        for (int i = 2; i <= result.getBody().getPageable().getPageSize(); i++) {
            Map<String, Integer> params = new HashMap<>();
            params.put("page", i);
            result = restTemplate.exchange(URL, HttpMethod.GET, null,
                    responseType, params);
            List<MedicalRecord> records = result.getBody().getContent();
            bloodPressure = Utility.findBloodPressure(records, diagnosisId, doctorName);

        }
        return bloodPressure;
    }
}
