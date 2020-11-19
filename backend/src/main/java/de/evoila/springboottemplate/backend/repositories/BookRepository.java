package de.evoila.springboottemplate.backend.repositories;

import de.evoila.springboottemplate.backend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
