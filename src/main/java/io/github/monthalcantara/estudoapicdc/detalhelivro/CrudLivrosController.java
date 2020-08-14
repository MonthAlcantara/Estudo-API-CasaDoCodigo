package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CrudLivrosController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private Uploader uploader;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.addValidators(new IsbnUnicoValidator(livroRepository), new TituloLivroUnicoValidator(livroRepository));
    }

    @PostMapping("/api/livro")
    @Transactional
    // Os dados do livro não virão em formato Json por causa do upload do arquivo.
    // Por isso não estou usando o requestBody. Nesse caso virá no formato form url enconder
    public void novo(@Valid NovoLivroForm form) {
        Livro livro = form.novoLivro(autorRepository, uploader);
        livroRepository.save(livro);

    }

}
