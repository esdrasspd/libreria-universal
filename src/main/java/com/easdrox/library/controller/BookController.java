package com.easdrox.library.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.easdrox.library.model.Author;
import com.easdrox.library.model.Book;
import com.easdrox.library.model.Genre;
import com.easdrox.library.model.Publisher;
import com.easdrox.library.services.AuthorService;
import com.easdrox.library.services.BookService;
import com.easdrox.library.services.GenreService;
import com.easdrox.library.services.PublisherService;

@Controller
public class BookController {
    
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final PublisherService publisherService;

    public BookController(BookService bookService, AuthorService authorService, GenreService genreService, PublisherService publisherService){
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
        this.publisherService = publisherService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        Iterable<Book> books = bookService.findAllBooks();
        Iterable<Author> allAuthors = authorService.findAllAuthors();
        Iterable<Genre> allGenres = genreService.findAllGenres();
        Iterable<Publisher> allPublishers = publisherService.findAllPublishers();

        model.addAttribute("books", books);
        model.addAttribute("bookSelected", books);
        model.addAttribute("allAuthors", allAuthors);
        model.addAttribute("authorSelected", allAuthors);
        model.addAttribute("allGenres", allGenres);
        model.addAttribute("genreSelected", allGenres);
        model.addAttribute("allPublishers", allPublishers);
        model.addAttribute("publisherSelected", allPublishers);
        return "viewBooks";
    }

    @PostMapping("/findBooks")
    public String findBooks( 
        @RequestParam(value = "id", defaultValue = "0") Integer id,
        @RequestParam(value = "idAuthor", defaultValue = "0") Integer idAuthor,
        @RequestParam(value = "idGenre", defaultValue = "0") Integer idGenre,
        @RequestParam(value = "idPublisher", defaultValue = "0") Integer idPublisher, Model model)
        {
        Iterable<Book> books = bookService.findAllBooks();
        Iterable<Book> bookSelected = bookService.searchBooks(id, idAuthor, idGenre, idPublisher);
        System.out.println(id);
        System.out.println(idAuthor+ " autor");
        Iterable<Author> allAuthors = authorService.findAllAuthors();
        Iterable<Genre> allGenres = genreService.findAllGenres();
        Iterable<Publisher> allPublishers = publisherService.findAllPublishers();
        
        model.addAttribute("books", bookSelected);
        model.addAttribute("id", id);
        model.addAttribute("bookSelected", books);
        model.addAttribute("allAuthors", allAuthors);
        model.addAttribute("idAuthor", idAuthor);
        model.addAttribute("authorSelected", allAuthors);
        model.addAttribute("allGenres", allGenres);
        model.addAttribute("idGenre", idGenre);
        model.addAttribute("genreSelected", allGenres);
        model.addAttribute("allPublishers", allPublishers);
        model.addAttribute("idPublisher", idPublisher);
        model.addAttribute("publisherSelected", allPublishers);

        
        return "viewBooks";
    }

    @RequestMapping("/addBooks")
    public String addBooks(Model model){
        return "viewSaveBooks";
    }

    @PostMapping("/saveBooks")
    public String saveBooks(@RequestParam String name, 
    @RequestParam Author author, @RequestParam String yearPublication, @RequestParam Integer stock, 
   @RequestParam Genre genre, @RequestParam Publisher publisher) {


        bookService.saveBook(new Book(name, author, yearPublication, stock, genre, publisher));

        return "redirect:/books";
    }

    @ModelAttribute("allAuthors")
    public Iterable<Author> populateAuthors() {
        return authorService.findAllAuthors();
    }

    @ModelAttribute("allGenres")
    public Iterable<Genre> populateGenres() {
        return genreService.findAllGenres();
    }

    @ModelAttribute("allPublishers")
    public Iterable<Publisher> populatePublishers() {
        return publisherService.findAllPublishers();
    }

    @GetMapping("/deleteBooks/{id}")
    public String deleteBook(@PathVariable int id) {
        // Eliminar el libro por ID
        bookService.deleteBookById(id);

        // Redirigir a la página de lista de libros después de la eliminación
        return "redirect:/books";
    }

    
    @GetMapping("/editBooks/{id}")
    public String editBook(@PathVariable int id, Model model) {
        
        Book book = bookService.findBookById(id);
        
        model.addAttribute("book", book);
        
        return "viewEditBook";
    }

    @PostMapping("/editBooks/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute Book updatedBook) {
    
        bookService.saveBook(updatedBook);

        return "redirect:/books";
    }


}
