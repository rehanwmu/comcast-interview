package com.comcast.interview.consumer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalRecord {
    private Integer id;
    private String timestamp;
    private Integer userId;
    private String userName;
    private String userDob;
    private Diagnosis diagnosis;
    private Doctor doctor;
    private Vitals vitals;
}
