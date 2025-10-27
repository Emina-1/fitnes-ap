package fitness_aplikacija.demo.model;

import java.util.List;

public class Trainer {
    private int id;
    private String name;
    private String specialty;
    private int experienceYears;
    private List<Exercise> exercises;

    public Trainer() {
    }

    public Trainer(int id, String name, String specialty, int experienceYears, List<Exercise> exercises) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.experienceYears = experienceYears;
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
