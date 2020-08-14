package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CrudCategoriasController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @InitBinder("novaCategoriaForm") //Marcar como método de iniciação. Posso dizer o escopo, a classe que ele será aplicado
    public void init(WebDataBinder dataBinder) {
    dataBinder.addValidators(new SemCategoriaComNomeDuplicadoValidator(categoriaRepository));
    //criei um validador personalizado para não permitir criação de duas categorias com mesmo nome
    }

    @PostMapping("/api/")
    public Categoria nova(@Valid @RequestBody NovaCategoriaForm novaCategoria) {
        Categoria categoria = new Categoria(novaCategoria.getNome());
        return categoriaRepository.save(categoria);
    }

}
