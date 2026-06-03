package Project.Portfolio.dto;

import Project.Portfolio.entity.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProyectoDTO {

    private Long id;
    private String descripcion;
    private String enlace;
    private LocalDate fecha;

    private String titulo;

    private Long usuarioId;

    private  String imagen;
}
