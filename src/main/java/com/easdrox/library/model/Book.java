package com.easdrox.library.model;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;


    @Column(name = "year_publication")
    private String yearPublication;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "genre")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "publisher")
    private Publisher publisher;

    public Book() {
    }

    public Book(String name, Author author, String yearPublication, Integer stock, Genre genre,
            Publisher publisher) {
        super();
        this.name = name;
        this.author = author;
        this.yearPublication = yearPublication;
        this.stock = stock;
        this.genre = genre;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public Integer getStock() {
        return stock;
    }

    public Genre getGenre() {
        return genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book [ id = " + id +", author=" + author + ", genre=" + genre + ", id=" + id + ", name=" + name + ", publisher="
                + publisher + ", stock=" + stock + ", yearPublication=" + yearPublication + "]";
    }

}
