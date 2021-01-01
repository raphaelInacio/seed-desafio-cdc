package br.com.casadocodigo.seed.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        AutorRequest autor = (AutorRequest) target;

        Optional<Autor> esseEmailJaExiste = repository.findAutorByEmail(autor.getEmail());

        if (esseEmailJaExiste.isPresent()) {
            errors.rejectValue("email", "{email.duplcado}");
        }
    }
}
