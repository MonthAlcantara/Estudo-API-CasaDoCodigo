package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LivroRepository extends CrudRepository<Livro, Long> {

    Optional<Livro> findByIsbn(String isbn);

    Optional<Livro> findByTitulo(String titulo);
}
