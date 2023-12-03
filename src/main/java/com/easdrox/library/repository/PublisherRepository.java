package com.easdrox.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.easdrox.library.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
    
        // save
        Publisher save(Publisher publisher);
    
        // find all
        Iterable<Publisher> findAll();
    
        // find by id
        Publisher findById(int id);
    
        // delete
        void deleteById(int id);
}
