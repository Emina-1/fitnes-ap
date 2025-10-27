package fitness_aplikacija.demo.data;

import org.springframework.stereotype.Component;
import fitness_aplikacija.demo.model.Exercise;
import fitness_aplikacija.demo.model.Trainer;

import java.util.*;

@Component
public class DemoData {

    private final Map<Integer, Exercise> exercises = new LinkedHashMap<>();
    private final Map<Integer, Trainer> trainers = new LinkedHashMap<>();
    private int exerciseSeq = 1;
    private int trainerSeq = 1;

    public DemoData() {


        saveExercise(new Exercise(0, "Push-ups", "Chest", 10, "Easy"));
        saveExercise(new Exercise(0, "Squats", "Legs", 15, "Medium"));
        saveExercise(new Exercise(0, "Plank", "Core", 5, "Hard"));
        saveExercise(new Exercise(0, "Burpees", "Full Body", 12, "Hard"));
        saveExercise(new Exercise(0, "Lunges", "Legs", 10, "Medium"));


        saveTrainer(new Trainer(
                0,
                "Amar",
                "Snaga i izdržljivost",
                5,
                List.of(findExercise(1), findExercise(3), findExercise(5))
        ));

        saveTrainer(new Trainer(
                0,
                "Emin",
                "Kardio i kondicija",
                3,
                List.of(findExercise(2), findExercise(4))
        ));
    }


    public List<Exercise> findAllExercises() {
        return new ArrayList<>(exercises.values());
    }

    public Exercise findExercise(int id) {
        return exercises.get(id);
    }

    public Exercise saveExercise(Exercise e) {
        if (e.getId() == 0) {
            e.setId(exerciseSeq++);
        }
        exercises.put(e.getId(), e);
        return e;
    }

    //Metode za trenere
    public List<Trainer> findAllTrainers() {
        return new ArrayList<>(trainers.values());
    }

    public Trainer findTrainer(int id) {
        return trainers.get(id);
    }

    public Trainer saveTrainer(Trainer t) {
        if (t.getId() == 0) {
            t.setId(trainerSeq++);
        }
        trainers.put(t.getId(), t);
        return t;
    }

    // Dodavanje vježbe treneru
    public boolean addExerciseToTrainer(int trainerId, int exerciseId) {
        Trainer t = findTrainer(trainerId);
        Exercise e = findExercise(exerciseId);
        if (t == null || e == null) return false;

        List<Exercise> list = new ArrayList<>(t.getExercises());
        list.add(e);
        t.setExercises(list);
        return true;
    }
}
