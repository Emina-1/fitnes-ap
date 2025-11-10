package fitness_aplikacija.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String goal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    @JsonIgnoreProperties("clients")
    private Trainer trainer;

    public Client() {}

    public Client(Long id, String name, int age, String goal, Trainer trainer) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.goal = goal;
        this.trainer = trainer;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGoal() { return goal; }
    public Trainer getTrainer() { return trainer; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGoal(String goal) { this.goal = goal; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }
}
