package de.evoila.springboottemplate.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "books")
@Entity
public class Book extends BaseEntity {

    private String name;
    private String isbn;
    private int pages;
    private int author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pages=" + pages +
                ", author=" + author +
                '}';
    }
}