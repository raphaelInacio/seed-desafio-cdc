package br.com.casadocodigo.seed.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaDuplicadaValidator categoriaDuplicadaValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(categoriaDuplicadaValidator);
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@Valid @RequestBody CategoriaRequest request) throws Exception {
        var categorria = repository.save(CategoriaMapper.mapperToModel(request)); //4
        return new ResponseEntity<>(categorria, HttpStatus.OK); //5
    }
}
