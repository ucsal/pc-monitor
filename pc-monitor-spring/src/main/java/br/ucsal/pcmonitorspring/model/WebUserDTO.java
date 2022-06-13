package br.ucsal.pcmonitorspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebUserDTO {
    private String login;

    private String password;

    private String role;
}
