package br.com.casadocodigo.seed.livro;

import br.com.casadocodigo.seed.autor.Autor;
import br.com.casadocodigo.seed.categoria.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class LivroMapper {

    @Autowired
    private EntityManager entityManager;

    Livro mapper(LivroRequest livroRequest) {
        return Livro.builder()
                .autor(entityManager.find(Autor.class, livroRequest.getIdAutor()))
                .categoria(entityManager.find(Categoria.class, livroRequest.getIdCategoria()))
                .dataDePublicacao(livroRequest.getDataDePublicacao())
                .numeroDePaginas(livroRequest.getNumeroDePaginas())
                .preco(livroRequest.getPreco())
                .resumo(livroRequest.getResumo())
                .sumario(livroRequest.getSumario())
                .titulo(livroRequest.getTitulo()).build();
    }
}
