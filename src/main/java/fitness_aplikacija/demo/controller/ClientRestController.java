package fitness_aplikacija.demo.controller;

import fitness_aplikacija.demo.model.Client;
import fitness_aplikacija.demo.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client existing = clientService.findById(id);
        existing.setName(client.getName());
        existing.setAge(client.getAge());
        existing.setGoal(client.getGoal());
        existing.setTrainer(client.getTrainer());
        return clientService.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
