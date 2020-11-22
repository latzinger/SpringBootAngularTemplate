package de.evoila.springboottemplate.backend.controller;

import de.evoila.springboottemplate.backend.model.Book;
import de.evoila.springboottemplate.backend.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/secure/books")
public class BookRestController {

    private final BookRepository bookRepository;
    private final Logger log = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("[DELETE] secure/books/" + id);
        bookRepository.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        log.info("[GET] secure/books/" + id);
        Optional<Book> book = bookRepository.findById(id);
        return ResponseEntity.ok(book.get());
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<Iterable<Book>> getAll() {
        log.info("[GET] secure/books/");
        Iterable<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<Book> post(@RequestBody Book book) {
        log.info("[POST] secure/books/");
        return ResponseEntity.ok(bookRepository.save(book));
    }

    /* Equivalent PUT Request
    @RequestMapping(method = RequestMethod.PUT, value = "")
    public ResponseEntity<Book> put(@RequestBody Book book) {
        log.info("[PUT] secure/books/");
        return ResponseEntity.ok(bookRepository.save(book));
    }

    */

}