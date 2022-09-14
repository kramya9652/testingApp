package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.tmo.paspringstarter.model.Books;

@RestController
public class LibraryController {

    private List<Books> booksList;
    private Integer autoincrement;

    public LibraryController() {
        this.autoincrement = 0;
        this.booksList = new ArrayList<>();
        this.booksList.add(new Books(1, "Bruce Eckel", "Thinking in Java", 1967));
        this.autoincrement++;
        this.booksList.add(new Books(2, "Sierra Kathy, Bates Bert", "Rusz glowa, Java.", 1970));
        this.autoincrement++;
        this.booksList.add(new Books(3, "Cay Horstmann, Gary Cornell", "Java 2. Podstawy", 1975));
        this.autoincrement++;
    }

    @GetMapping("/api/books")
    public List<Books> findAll() {
        return this.booksList;
    }

    public void save(Object o) {
        Books books = (Books) o;
        if (books.getId() == null) {
            add(books);
        } else {
            update(books);
        }
    }
    @PostMapping("/api/books")
    private ResponseEntity<Books> add(@RequestBody Books books) {



        try {
            books.setId(++autoincrement);
            this.booksList.add(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResponseEntity<Books> book = new ResponseEntity<>(books,HttpStatus.CREATED);
        return book;
    }

    private void update(@RequestBody Books books) {
        try {
            Integer indexOfOldEl = this.booksList.indexOf(books);
            this.booksList.set(indexOfOldEl, books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<List<Books>> delete() {
        this.booksList.clear();
        ResponseEntity<List<Books>> book = new ResponseEntity<List<Books>>(booksList,HttpStatus.NO_CONTENT);
        return book;

    }

    @GetMapping("/health")
    public void health() {

    }
}
