package fitness_aplikacija.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fitness_aplikacija.demo.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
