package fitness_aplikacija.demo.controller;

import fitness_aplikacija.demo.model.Exercise;
import fitness_aplikacija.demo.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseRestController {

    private final ExerciseService exerciseService;

    public ExerciseRestController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }


    @GetMapping
    public List<Exercise> getAll() {
        return exerciseService.findAll();
    }


    @GetMapping("/{id}")
    public Exercise getOne(@PathVariable Long id) {
        return exerciseService.findById(id);
    }


    @PostMapping
    public Exercise add(@RequestBody Exercise exercise) {
        return exerciseService.save(exercise);
    }


    @PutMapping("/{id}")
    public Exercise update(@PathVariable Long id, @RequestBody Exercise exercise) {
        exercise.setId(id);
        return exerciseService.save(exercise);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        exerciseService.delete(id);
    }
}
