package Project.Portfolio.controller;

import Project.Portfolio.dto.CrearProyectoHerramientaDTO;
import Project.Portfolio.dto.HerramientaDTO;
import Project.Portfolio.dto.VerProyectoHerramientaDTO;
import Project.Portfolio.entity.Herramienta;
import Project.Portfolio.entity.Proyecto;
import Project.Portfolio.entity.ProyectoHerramienta;
import Project.Portfolio.service.ProyectoHerramientaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecto-herramientas")
public class ProyectoHerramientaController {

    @Autowired
    private ProyectoHerramientaService service;

    @PostMapping
    public ResponseEntity<CrearProyectoHerramientaDTO> crear(@RequestBody CrearProyectoHerramientaDTO dto){

        ProyectoHerramienta ph = new ProyectoHerramienta();
        Proyecto proyecto = new Proyecto();
        proyecto.setId(dto.getProyecto());

        Herramienta herramienta = new Herramienta();
        herramienta.setId(dto.getHerramienta());

        ph.setProyecto(proyecto);
        ph.setHerramienta(herramienta);

        ProyectoHerramienta guardado = service.crearProyectoHerramienta(ph);

        CrearProyectoHerramientaDTO response = new CrearProyectoHerramientaDTO();
        response.setId(guardado.getId());
        response.setProyecto(guardado.getProyecto().getId());
        response.setHerramienta(guardado.getHerramienta().getId());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<VerProyectoHerramientaDTO>> obtenerTodos(){

        List<VerProyectoHerramientaDTO> lista = service.obtenerTodos()
                .stream()
                .map(ph -> {
                    VerProyectoHerramientaDTO dto = new VerProyectoHerramientaDTO();
                    dto.setId(ph.getId());
                    dto.setProyecto(ph.getProyecto().getId());
                    dto.setHerramienta(ph.getHerramienta());
                    return dto;
                })
                .toList();

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<HerramientaDTO>> obtenerPorProyecto(@PathVariable Long id) {

        List<HerramientaDTO> lista = service.obtenerPorProyecto(id)
                .stream()
                .map(ph -> {
                    Herramienta h = ph.getHerramienta();

                    HerramientaDTO dto = new HerramientaDTO();
                    dto.setId(h.getId());
                    dto.setNombre(h.getNombre());
                    dto.setIcono(h.getIcono());

                    return dto;
                })
                .toList();

        return ResponseEntity.ok(lista);
    }
}
