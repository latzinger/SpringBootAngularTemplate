package de.evoila.springboottemplate.backend.controller;

import de.evoila.springboottemplate.backend.model.Book;
import de.evoila.springboottemplate.backend.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/secure")
public class BookRestController {

    private final BookRepository bookRepository;
    private final Logger log = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @DeleteMapping(value = "/books/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Delete Book with Id: " + id);
        bookRepository.deleteById(id);
    }

    @GetMapping(value = "/books/{id}")
    public Book get(@PathVariable Long id) {
        log.info("Get Book with Id: " + id);
        return bookRepository.getOne(id);
    }

    @GetMapping(value = "/books")
    public Iterable<Book> books() {
        log.info("Get all books");
        return bookRepository.findAll();
    }

    @PutMapping(value = "/books")
    public Book put(@RequestBody Book book) {
        log.info("Saving " + book);
        return bookRepository.save(book);
    }

    @PostMapping(value = "/books")
    public Book post(@RequestBody Book book) {
        log.info("Updating " + book);
        return bookRepository.save(book);
    }
}