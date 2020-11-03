package br.com.casadocodigo.seed.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    public ResponseEntity<Autor> cadastrar(@Valid @RequestBody Autor novoAutor) throws Exception {

        Optional<Autor> esseEmailJaExiste = repository.findAutorByEmail(novoAutor.getEmail());

        if (esseEmailJaExiste.isPresent()) {
            throw new EmailCadastraoException("E-mail já cadastrado, insira um novo e-mail");
        }

        return new ResponseEntity<>(repository.save(novoAutor), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }


}
