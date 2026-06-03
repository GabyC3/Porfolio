package Project.Portfolio.controller;

import Project.Portfolio.dto.ContactoDTO;
import Project.Portfolio.entity.Contacto;
import Project.Portfolio.service.ContactoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    // Crear contacto
    @PostMapping
    public ResponseEntity<ContactoDTO> crearContacto(@RequestBody ContactoDTO dto) {
        Contacto nuevoContacto = new Contacto();
        nuevoContacto.setNombre(dto.getNombre());
        nuevoContacto.setCorreo(dto.getCorreo());
        nuevoContacto.setAsunto(dto.getAsunto());
        nuevoContacto.setMensaje(dto.getMensaje());
        nuevoContacto.setFecha(dto.getFecha());

        Contacto guardado = contactoService.crearContacto(nuevoContacto);

        ContactoDTO response = new ContactoDTO();
        response.setId(guardado.getId());
        response.setNombre(guardado.getNombre());
        response.setCorreo(guardado.getCorreo());
        response.setAsunto(dto.getAsunto());
        response.setMensaje(guardado.getMensaje());
        response.setFecha(guardado.getFecha());

        return ResponseEntity.ok(response);
    }

    // Obtener contacto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactoDTO> obtenerContactoPorId(@PathVariable Long id) {
        Optional<Contacto> contacto = contactoService.obtenerContactoPorId(id);

        if (contacto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Contacto c = contacto.get();

        ContactoDTO dto = new ContactoDTO();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setCorreo(c.getCorreo());
        dto.setAsunto(c.getAsunto());
        dto.setMensaje(c.getMensaje());
        dto.setFecha(c.getFecha());

        return ResponseEntity.ok(dto);
    }

    // Obtener todos los contactos
    @GetMapping
    public ResponseEntity<List<ContactoDTO>> obtenerTodos() {
        List<ContactoDTO> lista = contactoService.obtenerTodos()
                .stream()
                .map(contacto -> {
                    ContactoDTO dto = new ContactoDTO();
                    dto.setId(contacto.getId());
                    dto.setNombre(contacto.getNombre());
                    dto.setCorreo(contacto.getCorreo());
                    dto.setAsunto(contacto.getAsunto());
                    dto.setMensaje(contacto.getMensaje());
                    dto.setFecha(contacto.getFecha());
                    return dto;
                })
                .toList();
        return ResponseEntity.ok(lista);
    }

    // Actualizar contacto
    @PutMapping("/{id}")
    public ResponseEntity<Contacto> actualizarContacto(
            @PathVariable Long id,
            @RequestBody Contacto contactoActualizado) {

        Contacto contacto = contactoService.actualizarContacto(id, contactoActualizado);
        return ResponseEntity.ok(contacto);
    }

    // Eliminar contacto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable Long id) {
        contactoService.eliminarContacto(id);
        return ResponseEntity.noContent().build();
    }
}

