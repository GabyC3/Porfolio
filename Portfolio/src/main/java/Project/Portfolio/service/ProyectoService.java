package Project.Portfolio.service;

import Project.Portfolio.dto.ProyectoDTO;
import Project.Portfolio.entity.Proyecto;
import java.util.List;
import java.util.Optional;

public interface ProyectoService {
    Proyecto crearProyecto(Proyecto proyecto);
    Optional<Proyecto> obtenerProyectoPorId(Long id);
    List<Proyecto> obtenerTodos();
    void eliminarProyecto(Long id);
    Proyecto actualizarProyecto(Long id, Proyecto proyectoActualizado);
}
