package com.dylan.fitness.models;

import java.io.Serializable;

public class ExerciseLevel implements Serializable {
    private int id;
    private String exerciseLevel;
    private double counter;

    public ExerciseLevel(int id, String exerciseLevel, double counter) {
        this.id = id;
        this.exerciseLevel = exerciseLevel;
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public String getExerciseLevel() {
        return exerciseLevel;
    }

    public double getCounter() {
        return counter;
    }
}
