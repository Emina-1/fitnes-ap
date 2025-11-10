package fitness_aplikacija.demo.service;

import fitness_aplikacija.demo.model.Trainer;
import fitness_aplikacija.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository repo;

    public TrainerService(TrainerRepository repo) {
        this.repo = repo;
    }


    public List<Trainer> findAll() {
        return repo.findAll();
    }


    public Trainer findById(Long id) {
        return repo.findById(id).orElse(null);
    }


    public Trainer save(Trainer trainer) {
        return repo.save(trainer);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }
}
