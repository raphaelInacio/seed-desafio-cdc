package br.com.casadocodigo.seed.autor;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorRequest {

    private long id;

    @NotBlank(message = "{NotBlank}")
    private String nome;

    @Email
    @NotBlank(message = "{NotBlank}")
    private String email;

    @NotBlank(message = "{NotBlank}")
    @Size(max = 400)
    private String descricao;
}
