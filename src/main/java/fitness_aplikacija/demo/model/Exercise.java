package fitness_aplikacija.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String muscleGroup;
    private int durationMinutes;
    private String difficulty;

    @ManyToMany(mappedBy = "exercises", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("exercises")
    private List<Trainer> trainers;

    public Exercise() {}

    public Exercise(Long id, String name, String muscleGroup, int durationMinutes, String difficulty) {
        this.id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.durationMinutes = durationMinutes;
        this.difficulty = difficulty;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMuscleGroup() { return muscleGroup; }
    public int getDurationMinutes() { return durationMinutes; }
    public String getDifficulty() { return difficulty; }
    public List<Trainer> getTrainers() { return trainers; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMuscleGroup(String muscleGroup) { this.muscleGroup = muscleGroup; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public void setTrainers(List<Trainer> trainers) { this.trainers = trainers; }
}
