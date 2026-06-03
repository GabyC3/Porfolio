package Project.Portfolio.controller;

import Project.Portfolio.dto.ProyectoDTO;
import Project.Portfolio.entity.Proyecto;
import Project.Portfolio.entity.Usuario;
import Project.Portfolio.service.ProyectoService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping
    public ResponseEntity<ProyectoDTO> crearProyecto(@Valid @RequestBody ProyectoDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setId(dto.getUsuarioId());

        Proyecto nuevoProyecto = new Proyecto();
        nuevoProyecto.setTitulo(dto.getTitulo());
        nuevoProyecto.setDescripcion(dto.getDescripcion());
        nuevoProyecto.setEnlace(dto.getEnlace());
        nuevoProyecto.setFecha(dto.getFecha());
        nuevoProyecto.setUsuario(usuario);
        nuevoProyecto.setImagen(dto.getImagen());

        Proyecto guardado = proyectoService.crearProyecto(nuevoProyecto);

        ProyectoDTO response = new ProyectoDTO();
        response.setId(guardado.getId());
        response.setTitulo(guardado.getTitulo());
        response.setDescripcion(guardado.getDescripcion());
        response.setEnlace(guardado.getEnlace());
        response.setFecha(guardado.getFecha());
        response.setUsuarioId(guardado.getUsuario().getId());
        response.setImagen(guardado.getImagen());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> obtenerProyectoPorId(@PathVariable Long id) {
        Optional<Proyecto> proyecto = proyectoService.obtenerProyectoPorId(id);

        if (proyecto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Proyecto p = proyecto.get();

        ProyectoDTO dto = new ProyectoDTO();
        dto.setId(p.getId());
        dto.setTitulo(p.getTitulo());
        dto.setDescripcion(p.getDescripcion());
        dto.setEnlace(p.getEnlace());
        dto.setFecha(p.getFecha());
        dto.setUsuarioId(p.getUsuario().getId());
        dto.setImagen(p.getImagen());

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> obtenerTodos() {
        List<ProyectoDTO> proyectos = proyectoService.obtenerTodos()
                .stream()
                .map(proyecto -> {
                    ProyectoDTO dto = new ProyectoDTO();
                    dto.setId(proyecto.getId());
                    dto.setTitulo(proyecto.getTitulo());
                    dto.setDescripcion(proyecto.getDescripcion());
                    dto.setEnlace(proyecto.getEnlace());
                    dto.setFecha(proyecto.getFecha());
                    dto.setUsuarioId(proyecto.getUsuario().getId());
                    dto.setImagen(proyecto.getImagen());

                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(proyectos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDTO> actualizarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO dto) {

        try {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());

            Proyecto proyectoActualizado = new Proyecto();
            proyectoActualizado.setTitulo(dto.getTitulo());
            proyectoActualizado.setDescripcion(dto.getDescripcion());
            proyectoActualizado.setEnlace(dto.getEnlace());
            proyectoActualizado.setFecha(dto.getFecha());
            proyectoActualizado.setImagen(dto.getImagen());
            proyectoActualizado.setUsuario(usuario);

            Proyecto proyecto = proyectoService.actualizarProyecto(id, proyectoActualizado);

            ProyectoDTO response = new ProyectoDTO();
            response.setTitulo(proyecto.getTitulo());
            response.setDescripcion(proyecto.getDescripcion());
            response.setEnlace(proyecto.getEnlace());
            response.setFecha(proyecto.getFecha());
            response.setImagen(proyecto.getImagen());
            response.setUsuarioId(
                    proyecto.getUsuario() != null ? proyecto.getUsuario().getId() : null
            );

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.noContent().build();
    }
}