package fitness_aplikacija.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fitness_aplikacija.demo.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
