package br.com.casadocodigo.seed.autor;

import br.com.casadocodigo.seed.DataBuilder;
import br.com.casadocodigo.seed.SeedDesafioCdcApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AutorRepositoryTest extends SeedDesafioCdcApplicationTests {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    void deveSalvarAutoQuandoDadosEstaoCorretos() {
        Autor autor = this.autorRepository.save(
                DataBuilder.autor());
        Assertions.assertEquals("Raphael Inacio", autor.getNome());
    }
}