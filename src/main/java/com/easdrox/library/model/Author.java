package com.easdrox.library.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String birthday;

    private String nationality;

    public Author() {
    }

    public Author(String name, String birthday, String nationality){
        super();
        this.name = name;
        this.birthday = birthday;
        this.nationality = nationality;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getBirthday(){
        return birthday;
    }

    public String getNationality(){
        return nationality;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return name;
    }

}
