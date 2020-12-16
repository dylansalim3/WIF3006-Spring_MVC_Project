package com.dylan.fitness.bmi;

import org.springframework.stereotype.Service;

@Service("BmiService")
public class BmiServiceImpl implements BmiService {
    public double getBMI(double mass, double height) {
        return (mass / Math.pow(height, 2));
    }

    public String getCategory(double initialBmi) {
        double bmi = Math.round(initialBmi * 100) / 100;
        if (isBetween(bmi, 0, 15.99)) {
            return "Severe Thinness";
        } else if (isBetween(bmi, 16, 16.99)) {
            return "Moderate Thinness";
        } else if (isBetween(bmi, 17, 18.5)) {
            return "Mild Thinness";
        } else if (isBetween(bmi, 18.51, 24.99)) {
            return "Normal";
        } else if (isBetween(bmi, 25, 29.99)) {
            return "Obese Class I";
        } else {
            return "Obese Class II";
        }
    }

    public static boolean isBetween(double x, double lower, double upper) {
        return lower <= x && x <= upper;
    }
}
