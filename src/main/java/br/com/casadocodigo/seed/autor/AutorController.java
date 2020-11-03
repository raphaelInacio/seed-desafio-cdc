package br.com.casadocodigo.seed.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AutorController {

    @PostMapping("/v1/autores")
    public ResponseEntity<Autor> cadastrar(@Valid @RequestBody Autor novoAutor) {
        return new ResponseEntity<>(novoAutor, HttpStatus.OK);
    }
}
