package Project.Portfolio.dto;

import Project.Portfolio.entity.Herramienta;
import Project.Portfolio.entity.Proyecto;
import lombok.Data;
import java.util.List;

@Data
public class VerProyectoHerramientaDTO {

    private Long id;

    private Long proyecto;

    private Herramienta herramienta;

}