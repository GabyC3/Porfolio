package Project.Portfolio.service;

import Project.Portfolio.entity.ProyectoHerramienta;
import java.util.List;
import java.util.Optional;

public interface ProyectoHerramientaService {
    ProyectoHerramienta crearProyectoHerramienta(ProyectoHerramienta proyectoHerramienta);
    Optional<ProyectoHerramienta> obtenerPorId(Long id);
    List<ProyectoHerramienta> obtenerTodos();
    void eliminarPorId(Long id);
    ProyectoHerramienta actualizarProyectoHerramienta(Long id, ProyectoHerramienta proyectoActualizado);
    List<ProyectoHerramienta> obtenerPorProyecto(Long proyectoId);
}