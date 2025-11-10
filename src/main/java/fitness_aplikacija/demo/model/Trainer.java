package fitness_aplikacija.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialty;
    private int experienceYears;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "trainer_exercises",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    @JsonIgnoreProperties("trainers")
    private List<Exercise> exercises = new ArrayList<>();

    public Trainer() {}

    public Trainer(Long id, String name, String specialty, int experienceYears) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.experienceYears = experienceYears;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public int getExperienceYears() { return experienceYears; }
    public List<Exercise> getExercises() { return exercises; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
    public void setExercises(List<Exercise> exercises) { this.exercises = exercises; }


    public boolean canAddExercise() {
        return exercises.size() < 10;
    }

    public void addExercise(Exercise e) {
        if (canAddExercise()) {
            exercises.add(e);
        }
    }
}
