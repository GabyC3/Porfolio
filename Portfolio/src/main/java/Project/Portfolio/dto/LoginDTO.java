package Project.Portfolio.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginDTO {

    @Email
    private String correo;
    private String password;

    // getters y setters
}
