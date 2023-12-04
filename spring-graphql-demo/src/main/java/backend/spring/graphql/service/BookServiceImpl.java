package backend.spring.graphql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.spring.graphql.entity.BookEntity;
import backend.spring.graphql.model.Book;
import backend.spring.graphql.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(book, bookEntity);
        bookRepository.save(bookEntity);
        return book;

    }

    @Override
    public List<Book> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<Book> books = bookEntities.stream().map(book->new Book(
            book.getId(),
            book.getTitle(),
            book.getDesc(),
            book.getAuthor(),
            book.getPrice(),
            book.getPages()
        )).collect(Collectors.toList());

        return books;
    }

    @Override
    public Book getBookById(Integer bookId) {
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
        Book book = new Book();
        BeanUtils.copyProperties(bookEntity, book);
        return book;
    }

}
