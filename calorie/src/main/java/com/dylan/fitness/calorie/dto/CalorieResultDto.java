package com.dylan.fitness.calorie.dto;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

public class CalorieResultDto implements Serializable {
    //per day
    private int caloriesToMaintain;

    private int caloriesToMildWeightLoss;

    private int caloriesToWeightLoss;

    private int caloriesToExtremeWeightLoss;

    public CalorieResultDto() {
    }

    public int getCaloriesToMaintain() {
        return caloriesToMaintain;
    }

    public void setCaloriesToMaintain(int caloriesToMaintain) {
        this.caloriesToMaintain = caloriesToMaintain;
    }

    public int getCaloriesToMildWeightLoss() {
        return caloriesToMildWeightLoss;
    }

    public void setCaloriesToMildWeightLoss(int caloriesToMildWeightLoss) {
        this.caloriesToMildWeightLoss = caloriesToMildWeightLoss;
    }

    public int getCaloriesToWeightLoss() {
        return caloriesToWeightLoss;
    }

    public void setCaloriesToWeightLoss(int caloriesToWeightLoss) {
        this.caloriesToWeightLoss = caloriesToWeightLoss;
    }

    public int getCaloriesToExtremeWeightLoss() {
        return caloriesToExtremeWeightLoss;
    }

    public void setCaloriesToExtremeWeightLoss(int caloriesToExtremeWeightLoss) {
        this.caloriesToExtremeWeightLoss = caloriesToExtremeWeightLoss;
    }


}
