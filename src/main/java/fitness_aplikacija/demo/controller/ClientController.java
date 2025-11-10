package fitness_aplikacija.demo.controller;

import fitness_aplikacija.demo.model.Client;
import fitness_aplikacija.demo.model.Trainer;
import fitness_aplikacija.demo.repository.TrainerRepository;
import fitness_aplikacija.demo.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    private final TrainerRepository trainerRepository;

    public ClientController(ClientService clientService, TrainerRepository trainerRepository) {
        this.clientService = clientService;
        this.trainerRepository = trainerRepository;
    }

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("trainers", trainerRepository.findAll());
        model.addAttribute("client", new Client());
        return "clients";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute Client client, @RequestParam("trainerId") Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId).orElse(null);
        client.setTrainer(trainer);
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String editClient(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.findById(id));
        model.addAttribute("trainers", trainerRepository.findAll());
        return "clients";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute Client client,
                               @RequestParam("trainerId") Long trainerId) {
        Client existing = clientService.findById(id);
        Trainer trainer = trainerRepository.findById(trainerId).orElse(null);

        existing.setName(client.getName());
        existing.setAge(client.getAge());
        existing.setGoal(client.getGoal());
        existing.setTrainer(trainer);

        clientService.save(existing);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }
}
