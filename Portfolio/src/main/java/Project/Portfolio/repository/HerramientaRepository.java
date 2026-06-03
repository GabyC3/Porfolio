package Project.Portfolio.repository;

import Project.Portfolio.entity.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {
    // Si quieres métodos personalizados, agrégalos aquí
}
