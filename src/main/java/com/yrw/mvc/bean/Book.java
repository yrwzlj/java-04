package com.yrw.mvc.bean;

public class Book {
    private String name;

    private String author;

    private String category;

    private String profile;

    public Book(String name, String author, String category, String profile) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.profile = profile;
    }

    public Book(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
