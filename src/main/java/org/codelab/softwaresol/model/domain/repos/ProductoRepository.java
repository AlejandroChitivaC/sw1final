package org.codelab.softwaresol.model.domain.repos;

import org.codelab.softwaresol.model.domain.producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Override
    default <S extends Producto> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default List<Producto> findAll() {
        return null;
    }

    @Override
    default List<Producto> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    default <S extends Producto> S save(S entity) {
        return null;
    }

    @Override
    default Optional<Producto> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Integer integer) {
        return false;
    }
}