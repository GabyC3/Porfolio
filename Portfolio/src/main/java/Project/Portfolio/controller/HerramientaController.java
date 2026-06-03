package Project.Portfolio.controller;

import Project.Portfolio.dto.HerramientaDTO;
import Project.Portfolio.entity.Herramienta;
import Project.Portfolio.service.HerramientaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;

    @PostMapping
    public ResponseEntity<HerramientaDTO> crearHerramienta(@RequestBody HerramientaDTO dto) {
        Herramienta nuevaHerramienta = new Herramienta();
        nuevaHerramienta.setNombre(dto.getNombre());
        nuevaHerramienta.setIcono(dto.getIcono());

        Herramienta guardado = herramientaService.crearHerramienta(nuevaHerramienta);

        HerramientaDTO response = new HerramientaDTO();
        response.setId(guardado.getId());
        response.setNombre(guardado.getNombre());
        response.setIcono(guardado.getIcono());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HerramientaDTO> obtenerHerramientaPorId(@PathVariable Long id) {
        Optional<Herramienta> herramienta = herramientaService.obtenerHerramientaPorId(id);

        if (herramienta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Herramienta h = herramienta.get();
        HerramientaDTO dto = new HerramientaDTO();

        dto.setId(h.getId());
        dto.setNombre(h.getNombre());
        dto.setIcono(h.getIcono());

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<HerramientaDTO>> obtenerTodos() {
        List<HerramientaDTO> herramientas = herramientaService.obtenerTodos()
                .stream()
                .map(h -> {
                    HerramientaDTO dto = new HerramientaDTO();
                    dto.setId(h.getId());
                    dto.setNombre(h.getNombre());
                    dto.setIcono(h.getIcono());
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(herramientas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HerramientaDTO> actualizarHerramienta(@PathVariable Long id, @RequestBody HerramientaDTO dto) {

        Herramienta herramientaActualizada = new Herramienta();
        herramientaActualizada.setNombre(dto.getNombre());
        herramientaActualizada.setIcono(dto.getIcono());

        Herramienta herramienta = herramientaService.actualizarHerramienta(id, herramientaActualizada);
        HerramientaDTO response = new HerramientaDTO();
        response.setId(herramienta.getId());
        response.setNombre(herramienta.getNombre());
        response.setIcono(herramienta.getIcono());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHerramienta(@PathVariable Long id) {
        herramientaService.eliminarHerramienta(id);
        return ResponseEntity.noContent().build();
    }
}

