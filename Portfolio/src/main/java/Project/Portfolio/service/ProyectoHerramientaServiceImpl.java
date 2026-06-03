package Project.Portfolio.service;

import  Project.Portfolio.entity.ProyectoHerramienta;
import  Project.Portfolio.repository.ProyectoHerramientaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoHerramientaServiceImpl implements ProyectoHerramientaService {

    @Autowired
    private ProyectoHerramientaRepository proyectoHerramientaRepository;

    @Override
    public ProyectoHerramienta crearProyectoHerramienta(ProyectoHerramienta proyectoHerramienta) {
        return proyectoHerramientaRepository.save(proyectoHerramienta);
    }

    @Override
    public Optional<ProyectoHerramienta> obtenerPorId(Long id) {
        return proyectoHerramientaRepository.findById(id);
    }

    @Override
    public List<ProyectoHerramienta> obtenerTodos() {
        return proyectoHerramientaRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        proyectoHerramientaRepository.deleteById(id);
    }

    @Override
    public ProyectoHerramienta actualizarProyectoHerramienta(Long id, ProyectoHerramienta proyectoActualizado) {
        return proyectoHerramientaRepository.findById(id)
                .map(proyectoHerramienta -> {
                    // Aquí actualizas los campos que necesites
                    proyectoHerramienta.setProyecto(proyectoActualizado.getProyecto());
                    proyectoHerramienta.setHerramienta(proyectoActualizado.getHerramienta());
                    return proyectoHerramientaRepository.save(proyectoHerramienta);
                })
                .orElseThrow(() -> new RuntimeException("ProyectoHerramienta no encontrada con ID: " + id));
    }

    @Override
    public List<ProyectoHerramienta> obtenerPorProyecto(Long proyectoId) {
        return proyectoHerramientaRepository.findByProyectoId(proyectoId);
    }
}