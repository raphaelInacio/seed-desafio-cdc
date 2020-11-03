package br.com.casadocodigo.seed.autor;

@org.springframework.stereotype.Service
public class AutorService {

    private AutorRepository autorRepository;

    public Autor salvar(Autor novoAutor) {
        return autorRepository.save(novoAutor);
    }
}
