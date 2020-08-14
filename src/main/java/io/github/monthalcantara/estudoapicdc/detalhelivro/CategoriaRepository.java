package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
