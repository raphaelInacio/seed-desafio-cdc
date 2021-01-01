package br.com.casadocodigo.seed.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository; //1

    @Autowired
    private ProibeEmailDuplicadoValidator proibeEmailDuplicadoValidator; //2

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        //3
        dataBinder.addValidators(proibeEmailDuplicadoValidator);
    }

    @PostMapping //4
    public ResponseEntity<Autor> cadastrar(@Valid @RequestBody AutorRequest request) throws Exception {
        var autorCadastrado = repository.save(AutorMapper.mapperToModel(request)); //4
        return new ResponseEntity<>(autorCadastrado, HttpStatus.OK); //5
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }


}
