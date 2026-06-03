package Project.Portfolio.repository;

import Project.Portfolio.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    List<Contacto> findByUsuarioId(Long usuarioId);
}
