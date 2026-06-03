package Project.Portfolio.controller;

import Project.Portfolio.dto.LoginDTO;
import Project.Portfolio.entity.Usuario;
import Project.Portfolio.repository.UsuarioRepository;
import Project.Portfolio.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO login){


        Optional<Usuario> usuario =
                usuarioRepository.findByCorreo(login.getCorreo());


        if(usuario.isEmpty()){
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        Usuario u = usuario.get();

        if(!passwordEncoder.matches(login.getPassword(), u.getPassword())){
            return ResponseEntity.status(401).body("Password incorrecto");
        }

        String token = jwtUtil.generarToken(u.getCorreo());

        return ResponseEntity.ok(Map.of(
                "token", token,
                "correo", u.getCorreo(),
                "role", "ADMIN"
        ));


    }
}
