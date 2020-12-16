package com.dylan.fitness.calorie;

import com.dylan.fitness.calorie.dto.CalorieInputDto;
import com.dylan.fitness.calorie.dto.CalorieResultDto;
import com.dylan.fitness.models.ExerciseLevel;

public interface CalorieService {
    CalorieResultDto calculateCalorieLevel(CalorieInputDto calorieInputDto);

    ExerciseLevel[] getExerciseLevels();

    String[] getCalorieFormulaList();
}
