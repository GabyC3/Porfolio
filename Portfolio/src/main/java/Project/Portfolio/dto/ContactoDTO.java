package Project.Portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.aspectj.lang.annotation.RequiredTypes;

import java.time.LocalDateTime;

@Data
public class ContactoDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "Correo inválido")
    private String correo;

    private String asunto;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    private LocalDateTime fecha;

}
