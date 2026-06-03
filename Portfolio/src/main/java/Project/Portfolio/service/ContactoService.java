package Project.Portfolio.service;

import Project.Portfolio.dto.ContactoDTO;
import Project.Portfolio.entity.Contacto;
import java.util.List;
import java.util.Optional;

public interface ContactoService {
    Contacto crearContacto(Contacto contacto);
    Optional<Contacto> obtenerContactoPorId(Long id);
    List<Contacto> obtenerTodos();
    void eliminarContacto(Long id);
    Contacto actualizarContacto(Long id, Contacto contactoActualizado);
}
