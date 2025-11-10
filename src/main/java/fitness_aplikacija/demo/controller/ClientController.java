package fitness_aplikacija.demo.controller;

import fitness_aplikacija.demo.model.Client;
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
        return "clients";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("trainers", trainerRepository.findAll());
        return "clients";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.findById(id));
        model.addAttribute("trainers", trainerRepository.findAll());
        return "clients";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute Client client) {
        Client existing = clientService.findById(id);
        existing.setName(client.getName());
        existing.setAge(client.getAge());
        existing.setGoal(client.getGoal());
        existing.setTrainer(client.getTrainer());
        clientService.save(existing);
        return "redirect:/clients";
    }
}
