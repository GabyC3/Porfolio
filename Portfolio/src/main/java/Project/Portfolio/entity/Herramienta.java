package Project.Portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Herramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String icono;

    // Getters y Setters

}
