package fitness_aplikacija.demo.controller;

import fitness_aplikacija.demo.model.Trainer;
import fitness_aplikacija.demo.model.Exercise;
import fitness_aplikacija.demo.service.TrainerService;
import fitness_aplikacija.demo.repository.ExerciseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
public class TrainerRestController {

    private final TrainerService trainerService;
    private final ExerciseRepository exerciseRepo;

    public TrainerRestController(TrainerService trainerService, ExerciseRepository exerciseRepo) {
        this.trainerService = trainerService;
        this.exerciseRepo = exerciseRepo;
    }

    @GetMapping
    public List<Trainer> getAll() {
        return trainerService.findAll();
    }

    @GetMapping("/{id}")
    public Trainer getOne(@PathVariable Long id) {
        return trainerService.findById(id);
    }

    @PostMapping
    public Trainer add(@RequestBody Trainer trainer) {
        return trainerService.save(trainer);
    }

    @PutMapping("/{id}")
    public Trainer update(@PathVariable Long id, @RequestBody Trainer trainer) {
        Trainer existing = trainerService.findById(id);
        if (existing != null) {
            trainer.setId(id);
            return trainerService.save(trainer);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trainerService.delete(id);
    }

    @PostMapping("/{trainerId}/exercises/{exerciseId}")
    public Trainer addExerciseToTrainer(@PathVariable Long trainerId, @PathVariable Long exerciseId) {
        Trainer trainer = trainerService.findById(trainerId);
        Exercise exercise = exerciseRepo.findById(exerciseId).orElse(null);

        if (trainer != null && exercise != null && trainer.canAddExercise()) {
            trainer.addExercise(exercise);
            return trainerService.save(trainer);
        }
        return null;
    }
}
