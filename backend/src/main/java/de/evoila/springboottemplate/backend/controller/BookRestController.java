package de.evoila.springboottemplate.backend.controller;

import de.evoila.springboottemplate.backend.model.Book;
import de.evoila.springboottemplate.backend.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/secure/books")
public class BookRestController {

    private final BookRepository bookRepository;
    private final Logger log = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("[DELETE] secure/books/" + id);
        bookRepository.deleteById(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> get(@PathVariable Long id) {
        log.info("[GET] secure/books/" + id);
        Book book = bookRepository.getOne(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Book>> books() {
        log.info("[GET] secure/books/");
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @PutMapping(value = "")
    public ResponseEntity<Book> put(@RequestBody Book book) {
        log.info("[PUT] secure/books/");
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @PostMapping(value = "")
    public ResponseEntity<Book> post(@RequestBody Book book) {
        log.info("[POST] secure/books/");
        return ResponseEntity.ok(bookRepository.save(book));
    }
}