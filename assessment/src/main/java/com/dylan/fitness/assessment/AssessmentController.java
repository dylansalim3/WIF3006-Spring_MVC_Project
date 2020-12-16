package com.dylan.fitness.assessment;

import com.dylan.fitness.bmi.BmiService;
import com.dylan.fitness.calorie.CalorieService;
import com.dylan.fitness.calorie.dto.CalorieInputDto;
import com.dylan.fitness.calorie.dto.CalorieResultDto;
import com.dylan.fitness.models.PersonalInfo;
import com.dylan.fitness.weight.IdealWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AssessmentController {

    @Autowired
    BmiService bmiService;

    @Autowired
    CalorieService calorieService;

    @Autowired
    IdealWeightService idealWeightService;

    @Autowired
    CalorieInputDto calorieInputDto;

    @RequestMapping(value = "/form")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("exerciseLevels", calorieService.getExerciseLevels());
        modelAndView.addObject("bmrFormulaList", calorieService.getCalorieFormulaList());
        System.out.println("exerciseLevels" + calorieService.getExerciseLevels()[0].getExerciseLevel());
        return modelAndView;
    }

    @RequestMapping(value = "/result")
    public ModelAndView showResult() {
        return new ModelAndView("result");
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView submitForm(PersonalInfo personalInfo) {
        ModelAndView modelAndView = new ModelAndView("result");
        //calculate bmi
        double bmi = bmiService.getBMI(personalInfo.getWeight(), personalInfo.getHeight() / 100);
        String bmiCategory = bmiService.getCategory(bmi);
        modelAndView.addObject("bmi", String.format("%.2f",bmi));
        modelAndView.addObject("bmiCategory", bmiCategory);


        //calculate calorie
        calorieInputDto.setAge(personalInfo.getAge());
        calorieInputDto.setBodyFat(personalInfo.getBodyFat());
        calorieInputDto.setExerciseLevel(calorieService.getExerciseLevels()[personalInfo.getExerciseLevelId()]);
        calorieInputDto.setFormula(personalInfo.getCalorieFormula());
        calorieInputDto.setGender(personalInfo.getGender());
        calorieInputDto.setHeight(personalInfo.getHeight());
        calorieInputDto.setWeight(personalInfo.getWeight());

        CalorieResultDto calorieResultDto = calorieService.calculateCalorieLevel(calorieInputDto);
        int caloriesToMaintain = calorieResultDto.getCaloriesToMaintain();
        int caloriesToMildWeightLoss = calorieResultDto.getCaloriesToMildWeightLoss();
        int caloriesToWeightLoss = calorieResultDto.getCaloriesToWeightLoss();
        int caloriesToExtremeWeightLoss = calorieResultDto.getCaloriesToExtremeWeightLoss();
        modelAndView.addObject("caloriesToMaintain", caloriesToMaintain);
        modelAndView.addObject("caloriesToMildWeightLoss", caloriesToMildWeightLoss);
        modelAndView.addObject("caloriesToWeightLoss", caloriesToWeightLoss);
        modelAndView.addObject("caloriesToExtremeWeightLoss", caloriesToExtremeWeightLoss);

        //calculate ideal weight
        double idealWeight = idealWeightService.calIdealWeight(personalInfo.getHeight()/100, personalInfo.getGender());
        modelAndView.addObject("idealWeight", String.format("%.2f",idealWeight));

        System.out.println("submit: " + personalInfo.toString());
        System.out.println("math:" + String.valueOf(100 / Math.pow(10, 2)));
        System.out.println("bmi: " + String.valueOf(bmi));
        return modelAndView;
    }
}
