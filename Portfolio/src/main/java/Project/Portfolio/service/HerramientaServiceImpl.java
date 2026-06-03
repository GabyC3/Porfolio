package Project.Portfolio.service;

import Project.Portfolio.dto.HerramientaDTO;
import Project.Portfolio.entity.Herramienta;
import Project.Portfolio.repository.HerramientaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HerramientaServiceImpl implements HerramientaService {

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Override
    public Herramienta crearHerramienta(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }

    @Override
    public Optional<Herramienta> obtenerHerramientaPorId(Long id) {
        return herramientaRepository.findById(id);
    }

    @Override
    public List<Herramienta> obtenerTodos() {
        return herramientaRepository.findAll();
    }

    @Override
    public void eliminarHerramienta(Long id) {
        herramientaRepository.deleteById(id);
    }

    @Override
    public Herramienta actualizarHerramienta(Long id, Herramienta herramientaActualizada) {
        return herramientaRepository.findById(id)
                .map(herramienta -> {
                    herramienta.setNombre(herramientaActualizada.getNombre());
                    herramienta.setDescripcion(herramientaActualizada.getDescripcion());
                    herramienta.setIcono(herramientaActualizada.getIcono());
                    return herramientaRepository.save(herramienta);
                })
                .orElseThrow(() -> new RuntimeException("Herramienta no encontrada con ID: " + id));
    }
}
