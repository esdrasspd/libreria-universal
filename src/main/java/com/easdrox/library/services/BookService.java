package com.easdrox.library.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.easdrox.library.model.Book;
import com.easdrox.library.repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;
    private GenreService genreService;
    private PublisherService publisherService;

    public BookService(BookRepository bookRepository, AuthorService authorService, GenreService genreService, PublisherService publisherService){
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.genreService = genreService;
        this.publisherService = publisherService;

    }

    public Book findBookById(int id){
        return bookRepository.findById(id);
    }

    public List<Book> searchBooks(Integer id, Integer idAuthor, Integer idGenre, Integer idPublisher) {
         System.out.println("el id: "+id);
        return bookRepository.findBooks(id, idAuthor, idGenre, idPublisher);
       
    }

    public Iterable<Book> findAllBooks(){
        return bookRepository.findAll();

    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBookById(int id){
        bookRepository.deleteById(id);
    }

}
