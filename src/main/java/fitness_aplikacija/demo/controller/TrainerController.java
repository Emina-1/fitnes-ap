package fitness_aplikacija.demo.controller;

import fitness_aplikacija.demo.model.Trainer;
import fitness_aplikacija.demo.model.Exercise;
import fitness_aplikacija.demo.service.TrainerService;
import fitness_aplikacija.demo.repository.ExerciseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;
    private final ExerciseRepository exerciseRepo;

    public TrainerController(TrainerService trainerService, ExerciseRepository exerciseRepo) {
        this.trainerService = trainerService;
        this.exerciseRepo = exerciseRepo;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("trainers", trainerService.findAll());
        model.addAttribute("allExercises", exerciseRepo.findAll());
        return "trainers"; // -> templates/trainers.html
    }


    @GetMapping("/{id}")
    public String showTrainerDetails(@PathVariable Long id, Model model) {
        Trainer trainer = trainerService.findById(id);
        if (trainer == null) {
            return "redirect:/trainers";
        }
        model.addAttribute("trainer", trainer);
        return "trainer-details"; // -> templates/trainer-details.html
    }


    @PostMapping("/add")
    public String addTrainer(Trainer trainer) {
        trainerService.save(trainer);
        return "redirect:/trainers";
    }


    @GetMapping("/delete/{id}")
    public String deleteTrainer(@PathVariable Long id) {
        trainerService.delete(id);
        return "redirect:/trainers";
    }


    @PostMapping("/addExercise")
    public String addExerciseToTrainer(@RequestParam Long trainerId, @RequestParam Long exerciseId) {
        Trainer trainer = trainerService.findById(trainerId);
        Exercise exercise = exerciseRepo.findById(exerciseId).orElse(null);

        if (trainer != null && exercise != null && trainer.canAddExercise()) {
            trainer.addExercise(exercise);
            trainerService.save(trainer);
        }
        return "redirect:/trainers";
    }
}
