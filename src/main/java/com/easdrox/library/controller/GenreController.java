package com.easdrox.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.easdrox.library.model.Book;
import com.easdrox.library.model.Genre;
import com.easdrox.library.services.GenreService;

@Controller
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }

    @RequestMapping("/genres")
    public String getGenres(Model model){
        Iterable<Genre> genres = genreService.findAllGenres();
        model.addAttribute("genres", genres);
        model.addAttribute("genreSelected", genres);
        return "viewGenres";
    }

    @PostMapping("/findGenres")
    public String findGenres(
        @RequestParam(value = "id", defaultValue = "0") Integer id,
        Model model) {
        Genre genre = genreService.findGenreById(id);
        model.addAttribute("genres", genre);
        Iterable<Genre> genres = genreService.findAllGenres();
        model.addAttribute("genreSelected", genres);
        return "viewGenres";
    }

    @RequestMapping("/addGenres")
    public String addGenres(Model model){
        return "viewSaveGenres";
    }

    @PostMapping("/saveGenres")
    public String saveGenre(@RequestParam String name,
            @RequestParam String description){
        System.out.println("Nombre: " + name);

        genreService.saveGenre(new Genre(name, description));

        return "redirect:/genres";
    }

    @GetMapping("/editGenres/{id}")
    public String editBook(@PathVariable int id, Model model) {
        
        Genre genre = genreService.findGenreById(id);
        
        model.addAttribute("genre", genre);
        
        return "viewEditGenres";
    }

    @PostMapping("/editGenres/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute Genre updatedGenre) {
    
        genreService.saveGenre(updatedGenre);

        return "redirect:/genres";
    }

}
