package com.Library.model;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findById(Integer id);

    boolean existsById(Integer id);

    Book save(Book entity);

    void deleteById(Integer id);

    void delete(Book entity);
}
