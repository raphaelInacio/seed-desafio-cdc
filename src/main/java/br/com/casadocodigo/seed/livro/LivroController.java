package br.com.casadocodigo.seed.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/livros")
public class LivroController {

    @Autowired
    private LivroMapper livroMapper; //1

    @Autowired
    private LivroRepository livroRepository; //2

    @Autowired
    private LivroValidator livroValidator; //3

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(livroValidator);
    }

    @PostMapping
    // 4
    // 5
    public ResponseEntity<Livro> cadastrar(@RequestBody @Valid LivroRequest request) {
        var livro = livroMapper.mapper(request);
        var novoLivro = livroRepository.save(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return new ResponseEntity<>(livroRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> listar(@RequestParam Long id) {
        return new ResponseEntity(livroRepository.findById(id), HttpStatus.OK);
    }
}
