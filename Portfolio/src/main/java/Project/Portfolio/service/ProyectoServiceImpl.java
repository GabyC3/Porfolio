package Project.Portfolio.service;

import Project.Portfolio.dto.ProyectoDTO;
import Project.Portfolio.entity.Proyecto;
import Project.Portfolio.repository.ProyectoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Optional<Proyecto> obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto actualizarProyecto(Long id, Proyecto proyectoActualizado) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        if (proyectoActualizado.getTitulo() != null) {
            proyecto.setTitulo(proyectoActualizado.getTitulo());
        }

        if (proyectoActualizado.getDescripcion() != null) {
            proyecto.setDescripcion(proyectoActualizado.getDescripcion());
        }

        if (proyectoActualizado.getEnlace() != null) {
            proyecto.setEnlace(proyectoActualizado.getEnlace());
        }
        proyecto.setFecha(proyectoActualizado.getFecha());
        proyecto.setUsuario(proyectoActualizado.getUsuario());

        if (proyectoActualizado.getImagen() != null) {
            proyecto.setImagen(proyectoActualizado.getImagen());
        }

        return proyectoRepository.save(proyecto);
    }
}
