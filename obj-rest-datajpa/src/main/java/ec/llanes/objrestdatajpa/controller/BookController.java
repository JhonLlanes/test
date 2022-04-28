package ec.llanes.objrestdatajpa.controller;

import ec.llanes.objrestdatajpa.modelo.Book;
import ec.llanes.objrestdatajpa.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class BookController {


    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    public List<Book> findall() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders handler) {
        try {
            System.out.println("HEADER: " + handler.get("User-Agent"));
            System.out.println("IP: " + handler.getOrigin());

            if (book.getId() != null) {
                log.warn("create a book wit id ");
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(repository.save(book));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findonebyId(@PathVariable Long id) {

        Optional<Book> bookstatus = repository.findById(id);

        if (bookstatus.isPresent()) {
            return ResponseEntity.ok(bookstatus.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/update")
    public ResponseEntity<Book> update(@RequestBody Book book, @RequestHeader HttpHeaders handler) {
        if (book.getId() == null) {
            log.warn("NO EXISTE EL TIPO DE LIBRO");
            return ResponseEntity.badRequest().build();
        }
        if (!repository.existsById(book.getId())) {
            log.warn("NO EXISTE EL TIPO DE LIBRO");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repository.save(book));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Book> delete(@RequestBody Book book) {
        repository.deleteById(book.getId());
        return ResponseEntity.noContent().build();
    }
}
