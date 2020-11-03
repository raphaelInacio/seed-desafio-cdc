package br.com.casadocodigo.seed.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date instante;

    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @Email(message = "E-mail invalido")
    @NotBlank(message = "E-mail não pode ser nulo")
    private String email;

    @NotBlank
    @Size(max = 400, message = "Mensagem não pode ter mais de 400 caracteres")
    private String descricao;
}
