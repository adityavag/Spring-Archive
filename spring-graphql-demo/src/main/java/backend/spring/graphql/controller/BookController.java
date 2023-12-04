package backend.spring.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.spring.graphql.model.Book;
import backend.spring.graphql.service.BookService;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    // 
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    // 
    // @GetMapping("/books")
    // public List<Book> getAllBooks() {
    //     return bookService.getAllBooks();
    // }

    // GraphQL Endpoint --------------------------------------
    @QueryMapping("allBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    // 
    // @GetMapping("/book/{id}")
    // public Book getBookById(@PathVariable Integer bookId) {
    //     return bookService.getBookById(bookId);
    // }
    
    // GraphQL Endpoint --------------------------------------
    @QueryMapping("getBook")
    public Book getBookById(@Argument Integer bookId) {
        return bookService.getBookById(bookId);
    }
}
