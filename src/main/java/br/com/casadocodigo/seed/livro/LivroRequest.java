package br.com.casadocodigo.seed.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LivroRequest {

    @NotBlank
    private String titulo;

    @NotNull
    @Size(max = 500, min = 1)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @DecimalMin(value = "20.0")
    private BigDecimal preco;

    @NotNull
    @Min(1)
    private int numeroDePaginas;

    @NotBlank
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotNull
    @Min(1)
    private Long idCategoria;

    @NotNull
    @Min(1)
    private Long idAutor;

}
