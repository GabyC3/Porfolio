package Project.Portfolio.controller;

import Project.Portfolio.entity.Usuario;
import Project.Portfolio.dto.UsuarioDTO;
import Project.Portfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setBiografia(dto.getBiografia());
        usuario.setFoto(dto.getFoto());

        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);

        UsuarioDTO response = new UsuarioDTO();
        response.setNombre(nuevoUsuario.getNombre());
        response.setCorreo(nuevoUsuario.getCorreo());
        response.setBiografia(nuevoUsuario.getBiografia());
        response.setFoto(nuevoUsuario.getFoto());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Long id) {

        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario u = usuario.get();

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNombre(u.getNombre());
        dto.setCorreo(u.getCorreo());
        dto.setBiografia(u.getBiografia());
        dto.setFoto(u.getFoto());

        return ResponseEntity.ok(dto);

    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodos() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerTodos()
        .stream()
        .map(usuario -> {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(usuario.getId());
            dto.setNombre(usuario.getNombre());
            dto.setCorreo(usuario.getCorreo());
            dto.setBiografia(usuario.getBiografia());
            dto.setFoto(usuario.getFoto());
            return dto;
        })
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO dto) {

        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado.setNombre(dto.getNombre());
        usuarioActualizado.setCorreo(dto.getCorreo());
        usuarioActualizado.setBiografia(dto.getBiografia());
        usuarioActualizado.setFoto(dto.getFoto());

        Usuario usuario = usuarioService.actualizarUsuario(id, usuarioActualizado);

        UsuarioDTO response = new UsuarioDTO();
        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setCorreo(usuario.getCorreo());
        response.setBiografia(usuario.getBiografia());
        response.setFoto(usuario.getFoto());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}