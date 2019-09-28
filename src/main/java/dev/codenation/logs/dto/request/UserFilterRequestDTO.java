package dev.codenation.logs.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@Builder
public class UserFilterRequestDTO {
    private String firstName;
    private String lastName;
    @Email
    private String email;
}
