package com.comcast.interview.consumer.util;

import com.comcast.interview.consumer.model.BloodPressure;
import com.comcast.interview.consumer.model.MedicalRecord;

import java.util.List;

public class Utility {

    public static BloodPressure findBloodPressure(List<MedicalRecord> medicalRecords,
                                                  Integer id, String doctorName) {
        BloodPressure bloodPressure = new BloodPressure();
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getDiagnosis().getId() == id &&
                    medicalRecord.getDoctor().getName().equalsIgnoreCase(doctorName)) {
                bloodPressure.setHigh(medicalRecord.getVitals().getBloodPressureDiastole());
                bloodPressure.setLow(medicalRecord.getVitals().getBloodPressureSystole());
            }
        }
        return bloodPressure;
    }
}
