package br.com.casadocodigo.seed.autor;

import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface AutorRepository {
    Autor save(Autor novoAutor);
}
