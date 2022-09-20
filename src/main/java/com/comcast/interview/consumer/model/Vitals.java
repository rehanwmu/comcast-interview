package com.comcast.interview.consumer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vitals {
    private Integer bloodPressureDiastole;
    private Integer bloodPressureSystole;
    private Integer pulse;
    private Integer breathingRate;
    private Double bodyTemperature;


}
