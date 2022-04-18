package ec.llanes.objrestdatajpa.controller;

import ec.llanes.objrestdatajpa.modelo.Book;
import ec.llanes.objrestdatajpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {


    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    public List<Book> findall(){
        return repository.findAll();
    }

    @PostMapping("/save")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders handler){
        try {
            System.out.println("HEADER: "+handler.get("User-Agent"));
            System.out.println("IP: "+handler.getOrigin());
            return repository.save(book);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

}
