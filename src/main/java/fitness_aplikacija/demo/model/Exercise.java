package fitness_aplikacija.demo.model;

public class Exercise {
    private int id;
    private String name;
    private String muscleGroup;
    private int durationMinutes;
    private String difficulty;

    public Exercise(){}

    public Exercise(int id, String name, String muscleGroup, int durationMinutes, String difficulty){
        this.id=id;
        this.name=name;
        this.muscleGroup=muscleGroup;
        this.durationMinutes=durationMinutes;
        this.difficulty=difficulty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
