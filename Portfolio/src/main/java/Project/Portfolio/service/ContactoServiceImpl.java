package Project.Portfolio.service;

import Project.Portfolio.dto.ContactoDTO;
import Project.Portfolio.entity.Contacto;
import Project.Portfolio.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public Contacto crearContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    @Override
    public Optional<Contacto> obtenerContactoPorId(Long id) {
        return contactoRepository.findById(id);

    }

    @Override
    public List<Contacto> obtenerTodos() {
        return contactoRepository.findAll();
    }

    @Override
    public void eliminarContacto(Long id) {
        contactoRepository.deleteById(id);
    }

    @Override
    public Contacto actualizarContacto(Long id, Contacto contactoActualizado) {
        return contactoRepository.findById(id)
                .map(contacto -> {
                    // Actualizamos los campos relevantes
                    contacto.setNombre(contactoActualizado.getNombre());
                    contacto.setCorreo(contactoActualizado.getCorreo());
                    contacto.setAsunto(contactoActualizado.getAsunto());
                    contacto.setMensaje(contactoActualizado.getMensaje());
                    contacto.setFecha(contactoActualizado.getFecha());
                    // Guardamos el contacto actualizado
                    return contactoRepository.save(contacto);
                })
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado con ID: " + id));
    }
}
