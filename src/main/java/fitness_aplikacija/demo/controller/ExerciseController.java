package fitness_aplikacija.demo.controller;

import fitness_aplikacija.demo.model.Exercise;
import fitness_aplikacija.demo.service.ExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }


    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("exercises", exerciseService.findAll());
        return "exercises"; // ime Thymeleaf template-a: exercises.html
    }


    @PostMapping("/add")
    public String add(Exercise exercise) {
        exerciseService.save(exercise);
        return "redirect:/exercises";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        exerciseService.delete(id);
        return "redirect:/exercises";
    }
}
