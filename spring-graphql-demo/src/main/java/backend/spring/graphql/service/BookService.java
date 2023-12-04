package backend.spring.graphql.service;

import java.util.List;

import backend.spring.graphql.model.Book;

public interface BookService {

    Book createBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Integer bookId);

}
