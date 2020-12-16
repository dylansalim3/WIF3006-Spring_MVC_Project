package com.dylan.fitness.bmi;

public interface BmiService {
    double getBMI(double mass, double height);
    String getCategory(double initialBmi);
}
