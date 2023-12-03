package com.easdrox.library.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.easdrox.library.model.Author;
import com.easdrox.library.services.AuthorService;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model) {
        Iterable<Author> authors = authorService.findAllAuthors();
        model.addAttribute("authors", authors);
        model.addAttribute("authorSelected", authors);
        return "viewAuthors";
    }

    @RequestMapping("/addAuthors")
    public String addBooks(Model model) {
        return "viewSaveAuthors";
    }

    @PostMapping("/findAuthorByName")
    public String findAuthorByName(
        @RequestParam(value = "id", defaultValue = "0") Integer id , 
        Model model) {
        Author author = authorService.findAuthorById(id);
        model.addAttribute("authors", author);
        Iterable<Author> authors = authorService.findAllAuthors();
        model.addAttribute("authorSelected", authors);
        model.addAttribute("id", id);
        return "viewAuthors";
    }

    @PostMapping("/saveAuthors")
public String saveAuthor(@RequestParam String name,
        @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") String birthday,
        @RequestParam String nationality) {
    System.out.println("Nombre: " + name);

    

    authorService.saveAuthor(new Author(name, birthday, nationality));

    return "redirect:/authors";
}

@GetMapping("/deleteAuthors{id}")
public String deleteAuthor(@PathVariable int id) {
    authorService.deleteAuthorById(id);
    return "redirect:/authors";
}

@GetMapping("/editAuthors/{id}")
public String editAuthor(@PathVariable int id, Model model) {
    Author author = authorService.findAuthorById(id);
    model.addAttribute("author", author);
    return "viewEditAuthors";
}

@PostMapping("/editAuthors/{id}")
public String updateAuthor(@PathVariable int id, @ModelAttribute Author author){
    
    authorService.saveAuthor(author);
    return "redirect:/authors";
}


}
