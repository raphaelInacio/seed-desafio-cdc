package br.com.casadocodigo.seed.categoria;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CategoriaRequest {

    @NotBlank(message = "{NotBlank}")
    private String nome;

}
