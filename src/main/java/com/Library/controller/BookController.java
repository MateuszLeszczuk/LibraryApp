package com.Library.controller;

import com.Library.model.Book;
import com.Library.model.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
class BookController {

    private final BookRepository repository;


    BookController(final BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Book> readSingleBook(@PathVariable int id) {
        return repository.findById(id)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> updateSingleBook(@PathVariable int id, @RequestBody Book toUpdate) {

        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();

        repository.findById(id)
                .ifPresent(book -> {
                    book.updateInfoFrom(toUpdate);
                    Book tmp = repository.save(book);
                });

        return ResponseEntity.ok(toUpdate);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSingeBook(@PathVariable int id) {
     if(!repository.existsById(id))
         return ResponseEntity.notFound().build();

     Optional<Book> tmpForBugFix = repository.findById(id);
     repository.deleteById(id);

     return ResponseEntity.ok(tmpForBugFix);
    }



    @PostMapping
    ResponseEntity<Book> addBook(@RequestBody Book toAdd) {
        Book result = repository.save(toAdd);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }


}
