package Project.Portfolio.repository;

import Project.Portfolio.entity.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {
    long countByFechaBetween(
            LocalDateTime inicio,
            LocalDateTime fin
    );
}
