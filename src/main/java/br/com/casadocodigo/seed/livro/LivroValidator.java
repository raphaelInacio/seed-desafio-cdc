package br.com.casadocodigo.seed.livro;

import br.com.casadocodigo.seed.autor.Autor;
import br.com.casadocodigo.seed.categoria.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class LivroValidator implements Validator {

    @Autowired
    EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return LivroRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        LivroRequest request = (LivroRequest) target;

        var categoria = Optional.ofNullable(entityManager.find(Categoria.class, request.getIdCategoria()));

        var autor = Optional.ofNullable(entityManager.find(Autor.class, request.getIdAutor()));

        if (!autor.isPresent()) {
            errors.rejectValue("idAutor", null, "Autor não cadastrado, cadastre um autor primeiro");
        }

        if (!categoria.isPresent()) {
            errors.rejectValue("idCategoria", null, "Categoria não cadastrada, cadastre uma categoria primeiro");

        }

    }
}
