package com.easdrox.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.easdrox.library.model.Genre;

public interface GenreRepository extends CrudRepository <Genre, Integer> {
    
    //save
    Genre save(Genre genre);

    //find all
    Iterable<Genre> findAll();

    //find by id
    Genre findById(int id);

    //delete
    void deleteById(int id);

}
