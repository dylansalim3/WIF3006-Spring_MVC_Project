package com.dylan.fitness.calorie;

import com.dylan.fitness.calorie.dto.CalorieResultDto;
import com.dylan.fitness.models.ExerciseLevel;

public class CalorieEquation {
    private static final String MALE = "male";
    private static final String FEMALE = "female";

    private static final int ONE_KG_CALORIES = 7700;
    private static final int ONE_KG_CALORIES_PER_WEEK = ONE_KG_CALORIES / 7;
    private static final int HALF_KG_CALORIES_PER_WEEK = ONE_KG_CALORIES_PER_WEEK / 2;
    private static final int QUARTER_KG_CALORIES_PER_WEEK = HALF_KG_CALORIES_PER_WEEK / 2;


    public static double calMiffin(double weight, double height, int age, String gender) {
        double general = (10 * weight) + (6.25 * height) - (5 * age);
        if (gender.equalsIgnoreCase(MALE)) {
            return general + 5;
        } else if (gender.equalsIgnoreCase(FEMALE)) {
            return general + 161;
        } else {
            return -1;
        }
    }

    public static double calHarris(double weight, double height, int age, String gender) {
        if (gender.equalsIgnoreCase(MALE)) {
            return (13.397 * weight) + (4.799 * height) - (5.677 * age) + 88.362;
        } else if (gender.equalsIgnoreCase(FEMALE)) {
            return (9.247 * weight) + (3.098 * height) - (4.330 * age) + 447.593;
        } else {
            return -1;
        }
    }

    public static double calKatch(double weight, double fat) {
        return 370 + (21.6 * (1 - fat) * weight);
    }

    public static double calDailyCaloriesRequired(double bmi, ExerciseLevel exerciseLevel) {
        return bmi * exerciseLevel.getCounter();
    }

    public static CalorieResultDto createResult(int dailyCaloriesRequired) {
        CalorieResultDto calorieResultDto = new CalorieResultDto();
        calorieResultDto.setCaloriesToMaintain(dailyCaloriesRequired);
        calorieResultDto.setCaloriesToMildWeightLoss(dailyCaloriesRequired - QUARTER_KG_CALORIES_PER_WEEK);
        calorieResultDto.setCaloriesToWeightLoss(dailyCaloriesRequired - HALF_KG_CALORIES_PER_WEEK);
        calorieResultDto.setCaloriesToExtremeWeightLoss(dailyCaloriesRequired - ONE_KG_CALORIES_PER_WEEK);
        return calorieResultDto;
    }
}
