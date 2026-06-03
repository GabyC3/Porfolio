package Project.Portfolio.service;

import Project.Portfolio.dto.HerramientaDTO;
import Project.Portfolio.entity.Herramienta;
import java.util.List;
import java.util.Optional;

public interface HerramientaService {
    Herramienta crearHerramienta(Herramienta herramienta);
    Optional<Herramienta> obtenerHerramientaPorId(Long id);
    List<Herramienta> obtenerTodos();
    void eliminarHerramienta(Long id);
    Herramienta actualizarHerramienta(Long id, Herramienta herramientaActualizada);
}
