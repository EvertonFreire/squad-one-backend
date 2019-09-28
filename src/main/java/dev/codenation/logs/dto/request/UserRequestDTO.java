package dev.codenation.logs.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import java.util.UUID;

@Data
@Builder
public class UserRequestDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String password;
}
