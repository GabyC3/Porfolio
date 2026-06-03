package Project.Portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import Project.Portfolio.service.VisitaService;
import java.util.Map;

@RestController
@RequestMapping("/api/visitas")
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @PostMapping
    public void registrarVisita(HttpServletRequest request) {

        System.out.println("VISITA RECIBIDA");
        String ip = request.getRemoteAddr();

        String userAgent =
                request.getHeader("User-Agent");

        visitaService.registrarVisita(
                ip,
                userAgent
        );
    }

    @GetMapping("/stats")
    public Map<String, Long> estadisticas() {

        return Map.of(
                "total",
                visitaService.obtenerTotalVisitas(),

                "hoy",
                visitaService.obtenerVisitasHoy()
        );
    }
}
