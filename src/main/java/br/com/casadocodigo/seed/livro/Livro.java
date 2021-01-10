package br.com.casadocodigo.seed.livro;

import br.com.casadocodigo.seed.autor.Autor;
import br.com.casadocodigo.seed.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotBlank
    @Size(min = 20)
    private BigDecimal preco;

    @NotBlank
    private Integer numeroDePaginas;

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotBlank
    @OneToOne
    private Categoria categoria;

    @NotBlank
    @OneToOne
    private Autor autor;

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario, @NotBlank @Size(min = 20) BigDecimal preco, @NotBlank Integer numeroDePaginas, @NotBlank LocalDate dataDePublicacao, @NotBlank Categoria categoria, @NotBlank Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }
}
