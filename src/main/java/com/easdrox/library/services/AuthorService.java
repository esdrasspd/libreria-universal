package com.easdrox.library.services;

import org.springframework.stereotype.Service;

import com.easdrox.library.model.Author;
import com.easdrox.library.repository.AuthorRepository;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author findAuthorById(int id){
        return authorRepository.findById(id);
    }

    public Iterable<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthorById(int id){
        authorRepository.deleteById(id);
    }
    

}
