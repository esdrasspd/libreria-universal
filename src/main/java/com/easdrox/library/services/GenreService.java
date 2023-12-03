package com.easdrox.library.services;

import org.springframework.stereotype.Service;

import com.easdrox.library.model.Genre;
import com.easdrox.library.repository.GenreRepository;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public Genre findGenreById(int id){
        return genreRepository.findById(id);
    }

    public Iterable<Genre> findAllGenres(){
        return genreRepository.findAll();
    }

    public Genre saveGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public void deleteGenreById(int id){
        genreRepository.deleteById(id);
    }
}