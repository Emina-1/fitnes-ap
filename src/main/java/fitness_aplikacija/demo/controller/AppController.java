package fitness_aplikacija.demo.controller;

import fitness_aplikacija.demo.data.DemoData;
import fitness_aplikacija.demo.model.Exercise;
import fitness_aplikacija.demo.model.Trainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    private final DemoData data;

    public AppController(DemoData data) {
        this.data = data;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/trainers";
    }

    @GetMapping("/trainers")
    public String trainers(Model model) {
        model.addAttribute("trainers", data.findAllTrainers());
        return "trainers";
    }

    @GetMapping("/trainer/{id}")
    public String trainerDetails(@PathVariable int id, Model model) {
        Trainer trainer = data.findTrainer(id);
        if (trainer == null) {
            return "redirect:/trainers";
        }
        model.addAttribute("trainer", trainer);
        model.addAttribute("allExercises", data.findAllExercises());
        return "trainer-details";
    }

    @GetMapping("/exercises")
    public String exercises(Model model) {
        model.addAttribute("exercises", data.findAllExercises());
        return "exercises";
    }

    @PostMapping("/exercises/add")
    public String addExercise(@RequestParam String name,
                              @RequestParam String muscleGroup,
                              @RequestParam int durationMinutes,
                              @RequestParam String difficulty) {

        Exercise newExercise = new Exercise(0, name, muscleGroup, durationMinutes, difficulty);
        data.saveExercise(newExercise);
        return "redirect:/exercises";
    }

    @PostMapping("/trainer/{trainerId}/addExercise")
    public String addExerciseToTrainer(@PathVariable int trainerId,
                                       @RequestParam int exerciseId) {
        data.addExerciseToTrainer(trainerId, exerciseId);
        return "redirect:/trainer/" + trainerId;
    }
}
