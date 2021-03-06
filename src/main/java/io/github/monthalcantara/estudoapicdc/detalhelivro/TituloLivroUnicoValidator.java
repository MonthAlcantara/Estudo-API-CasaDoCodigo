package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class TituloLivroUnicoValidator implements Validator {

    private LivroRepository livroRepository;

    public TituloLivroUnicoValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoLivroForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoLivroForm form = (NovoLivroForm) target;
        String titulo = form.getTitulo();
        Optional<Livro> possivelLivro = livroRepository.findByTitulo(titulo);

        if(possivelLivro.isPresent()){
            errors.rejectValue("titulo", null, "Já existe um livro com este titulo");
        }

    }
}

