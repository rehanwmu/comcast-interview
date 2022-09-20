package com.comcast.interview.consumer;

import com.comcast.interview.consumer.model.BloodPressure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {


    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class, args);
        Solution solution = new Solution();
        BloodPressure bloodPressure = solution.getData();
        System.out.println("High :" + bloodPressure.getHigh());
        System.out.println("Low :" + bloodPressure.getLow());


    }


}
