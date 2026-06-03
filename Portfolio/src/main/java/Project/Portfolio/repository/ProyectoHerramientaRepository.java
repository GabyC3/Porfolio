package Project.Portfolio.repository;

import Project.Portfolio.dto.VerProyectoHerramientaDTO;
import Project.Portfolio.entity.ProyectoHerramienta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProyectoHerramientaRepository extends JpaRepository<ProyectoHerramienta, Long> {
    List<ProyectoHerramienta> findByProyectoId(Long proyectoId);
}
