package com.comcast.interview.consumer.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class BloodPressure {
    private Integer high;
    private Integer low;
}
