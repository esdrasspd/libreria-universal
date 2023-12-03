package com.easdrox.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.easdrox.library.model.Author;

public interface AuthorRepository extends CrudRepository <Author, Integer> {
        
        //save
        Author save(Author author);
    
        //find all
        Iterable<Author> findAll();
    
        //find by id
        Author findById(int id);
    
        //delete
        void deleteById(int id);
}
