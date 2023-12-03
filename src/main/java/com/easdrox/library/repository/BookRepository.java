package com.easdrox.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easdrox.library.model.Book;

public interface BookRepository extends CrudRepository <Book, Integer> {
    
    //save
    Book save(Book book);

    //find all
    Iterable<Book> findAll();

    //find by id
    Book findById(int id);

    //delete
    void deleteById(int id);

    @Query("SELECT b FROM Book b WHERE (:id = 0 OR b.id = :id) AND (:idAuthor = 0 OR b.author.id = :idAuthor) " +
       "AND (:idGenre = 0 OR b.genre.id = :idGenre) AND (:idPublisher = 0 OR b.publisher.id = :idPublisher)")
List<Book> findBooks(@Param("id") Integer id, @Param("idAuthor") Integer idAuthor, 
                     @Param("idGenre") Integer idGenre, @Param("idPublisher") Integer idPublisher);

}
