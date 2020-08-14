package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class IsbnUnicoValidator implements Validator {

    private LivroRepository livroRepository;

    public IsbnUnicoValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoLivroForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoLivroForm form = (NovoLivroForm) target;
        String isbn = form.getIsbn();

        Optional<Livro> possivelLivro = livroRepository.findByIsbn(isbn);

        if(possivelLivro.isPresent()){
            errors.rejectValue("isbn", null, "Ja existe um livro cadastrado com esse isbn");
        }
    }
}


