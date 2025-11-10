package fitness_aplikacija.demo.service;

import fitness_aplikacija.demo.model.Exercise;
import fitness_aplikacija.demo.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository repo;

    public ExerciseService(ExerciseRepository repo) {
        this.repo = repo;
    }


    public List<Exercise> findAll() {
        return repo.findAll();
    }


    public Exercise findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Exercise save(Exercise exercise) {
        return repo.save(exercise);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
