package Project.Portfolio.service;

import Project.Portfolio.dto.UsuarioDTO;
import Project.Portfolio.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> obtenerUsuarioPorId(Long id);
    List<Usuario> obtenerTodos();
    void eliminarUsuario(Long id);
    Usuario actualizarUsuario(Long id, Usuario usuarioActualizado);
}
