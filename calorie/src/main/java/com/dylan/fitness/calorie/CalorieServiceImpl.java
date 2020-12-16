package com.dylan.fitness.calorie;

import com.dylan.fitness.calorie.dto.CalorieInputDto;
import com.dylan.fitness.calorie.dto.CalorieResultDto;
import com.dylan.fitness.models.ExerciseLevel;
import org.springframework.stereotype.Service;

@Service("CalorieService")
public class CalorieServiceImpl implements CalorieService{
    public static final String MIFFIN_ST_JEOR = "Mifflin-St Jeor Equation";
    public static final String REVISED_HARRIS_BENEDICT = "Revised Harris-Benedict Equation";
    public static final String KATCH_MCARDLE = "Katch-McArdle Formula";

    public static final String[] CALORIE_FORMULA_LIST = new String[]{MIFFIN_ST_JEOR, REVISED_HARRIS_BENEDICT, KATCH_MCARDLE};

    public static final ExerciseLevel[] EXERCISE_LEVELS = new ExerciseLevel[]{
            new ExerciseLevel(0, "Little to no exercise", 1.2),
            new ExerciseLevel(1, "Light Exercise (1-3 days per week)", 1.375),
            new ExerciseLevel(2, "Moderate Exercise (3-5 days per week)", 1.55),
            new ExerciseLevel(3, "Heavy exercise (6-7 days per week)", 1.725),
            new ExerciseLevel(4, "Very heavy exercise (twice per day, extra heavy workouts)", 1.9)
    };

    public ExerciseLevel[] getExerciseLevels(){
        return EXERCISE_LEVELS;
    }

    public String[] getCalorieFormulaList(){
        return CALORIE_FORMULA_LIST;
    }


    public CalorieResultDto calculateCalorieLevel(CalorieInputDto calorieInputDto) {
        if (null != calorieInputDto) {
            String gender = calorieInputDto.getGender();
            double weight = calorieInputDto.getWeight();
            double height = calorieInputDto.getHeight();
            int age = calorieInputDto.getAge();
            double bodyFat = calorieInputDto.getBodyFat();
            ExerciseLevel exerciseLevel = calorieInputDto.getExerciseLevel();
            double bmr = 0;
            switch (calorieInputDto.getFormula()) {
                case MIFFIN_ST_JEOR:
                    bmr = CalorieEquation.calMiffin(weight, height, age, gender);
                    break;
                case REVISED_HARRIS_BENEDICT:
                    bmr = CalorieEquation.calHarris(weight, height, age, gender);
                    break;
                case KATCH_MCARDLE:
                    bmr = CalorieEquation.calKatch(weight, bodyFat);
                    break;
                default:
                    return null;
            }
            int dailyCaloriesRequired = (int) Math.round(CalorieEquation.calDailyCaloriesRequired(bmr, exerciseLevel));
            return CalorieEquation.createResult(dailyCaloriesRequired);

        }
        return null;
    }

}
