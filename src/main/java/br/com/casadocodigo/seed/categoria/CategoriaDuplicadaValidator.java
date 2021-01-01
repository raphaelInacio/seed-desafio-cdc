package br.com.casadocodigo.seed.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaDuplicadaValidator implements Validator {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        CategoriaRequest categoriaRequest = (CategoriaRequest) target;
        Optional<Categoria> categoriaExiste = repository.findByNome(categoriaRequest.getNome());


        if (categoriaExiste.isPresent()) {
            errors.rejectValue("email", "{email.duplcado}");
        }
    }
}
