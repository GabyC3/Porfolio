package Project.Portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProyectoHerramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "herramienta_id")
    private Herramienta herramienta;



}
