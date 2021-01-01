package br.com.casadocodigo.seed;

import br.com.casadocodigo.seed.autor.Autor;

import java.time.LocalDateTime;

public class DataBuilder {
    public static Autor autor() {
        return new Autor(0,
                LocalDateTime.now(),
                "Raphael Inacio da Silva",
                "contato.raphaelinacio@gmail.com",
                "Autor de livros de tecnologia da informação");
    }
}
