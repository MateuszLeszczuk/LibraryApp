package com.Library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String author;

    private String description;

    private double price;

    Book() {

    }

    public Book(final String title, final String author, final String description, final double price) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    void setAuthor(final String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    void setPrice(final double price) {
        this.price = price;
    }

    public void updateInfoFrom(Book toUpdate){
        title = toUpdate.title;
        author = toUpdate.author;
        description = toUpdate.description;
        price = toUpdate.price;
    }
}
