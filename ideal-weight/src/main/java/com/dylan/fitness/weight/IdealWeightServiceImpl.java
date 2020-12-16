package com.dylan.fitness.weight;

import org.springframework.stereotype.Service;

@Service("IdealWeightService")
public class IdealWeightServiceImpl implements IdealWeightService {
    private static final String MALE = "male";
    private static final String FEMALE = "female";

    public double calIdealWeight(double height, String gender) {
        double counter = 0;
        if (gender.equalsIgnoreCase(MALE)) {
            counter = 21.5;
        } else if (gender.equalsIgnoreCase(FEMALE)) {
            counter = 23;
        }
        return Math.pow(height,2) * counter;
    }
}
