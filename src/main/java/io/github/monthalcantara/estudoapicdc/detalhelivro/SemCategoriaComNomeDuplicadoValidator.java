package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class SemCategoriaComNomeDuplicadoValidator implements Validator {

    private CategoriaRepository categoriaRepository;

    public SemCategoriaComNomeDuplicadoValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) { // Em qual classe essa validação será implementada "NovaCategoriaForm"
        return NovaCategoriaForm.class.isAssignableFrom(aClass);
        // A classe NovaCategoriaForm é a mãe ou a mesma do argumento aClass? Se for vai dar tudo certo
    }

    @Override
    public void validate(Object target, Errors errors) { // Método de Validação
        NovaCategoriaForm form = (NovaCategoriaForm) target;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(form.getNome()); // Verificando se ja existe o nome de categoria

        if (possivelCategoria.isPresent()) { // Se ja existir uma categoria com esse nome então eu rejeito o field "campo" findo do json, passando a msg
            errors.rejectValue("nome", null, "Ja existe uma categoria com esse nome"); // Nome do campo, código do erro, mensagem
        }
    }
}
