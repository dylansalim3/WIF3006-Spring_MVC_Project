package com.dylan.fitness.models;

import org.springframework.beans.factory.annotation.Value;

public class PersonalInfo {
    private int age;
    private Double height;
    private Double weight;
    private String gender;
    private int exerciseLevelId;
    private String calorieFormula;
    @Value("0.0")
    private Double bodyFat;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getExerciseLevelId() {
        return exerciseLevelId;
    }

    public void setExerciseLevelId(int exerciseLevelId) {
        this.exerciseLevelId = exerciseLevelId;
    }

    public String getCalorieFormula() {
        return calorieFormula;
    }

    public void setCalorieFormula(String calorieFormula) {
        this.calorieFormula = calorieFormula;
    }

    public double getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(double bodyFat) {
        this.bodyFat = bodyFat;
    }

    @Override
    public String toString() {
        return "PersonalInfo{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", exerciseLevelId=" + exerciseLevelId +
                ", calorieFormula='" + calorieFormula + '\'' +
                ", bodyFat=" + bodyFat +
                '}';
    }
}
