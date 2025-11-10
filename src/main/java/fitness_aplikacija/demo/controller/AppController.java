package fitness_aplikacija.demo.controller;

import fitness_aplikacija.demo.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    private final TrainerService trainerService;

    public AppController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/trainers";
    }

}
