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
    private CategoriaRepository repository; //1

    @Autowired
    private CategoriaDuplicadaValidator categoriaDuplicadaValidator; //2

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(categoriaDuplicadaValidator);
    }

    @PostMapping
    //3
    //4
    public ResponseEntity<Categoria> cadastrar(@Valid @RequestBody CategoriaRequest request) throws Exception {
        var categoria = repository.save(CategoriaMapper.mapperToModel(request));
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }
}
