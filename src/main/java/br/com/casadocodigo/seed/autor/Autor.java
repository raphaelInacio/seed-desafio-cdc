package br.com.casadocodigo.seed.autor;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data precisa ser informada")
    private Date instante;

    @NotBlank(message = "Nome precisa ser informada")
    private String nome;

    @Email(message = "E-mail invalido")
    @NotBlank(message = "E-mail precisa ser informada")
    private String email;

    @NotBlank(message = "Descrição precisa ser informada")
    @Size(max = 400, message = "Descrição não pode ter mais de 400 caracteres")
    private String descricao;
}
