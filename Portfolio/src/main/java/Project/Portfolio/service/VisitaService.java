package Project.Portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import Project.Portfolio.repository.VisitaRepository;
import Project.Portfolio.entity.Visita;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    public void registrarVisita(String ip, String userAgent) {

        Visita visita = new Visita();

        visita.setFecha(LocalDateTime.now());
        visita.setIp(ip);
        visita.setUserAgent(userAgent);

        visitaRepository.save(visita);
    }

    public long obtenerTotalVisitas() {
        return visitaRepository.count();
    }

    public long obtenerVisitasHoy() {

        LocalDateTime inicio =
                LocalDate.now().atStartOfDay();

        LocalDateTime fin =
                LocalDate.now().plusDays(1).atStartOfDay();

        return visitaRepository.countByFechaBetween(
                inicio,
                fin
        );
    }
}