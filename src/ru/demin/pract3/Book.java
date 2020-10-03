package ru.demin.pract3;

public class Book {
    private String author;
    private String name;
    private int yearOfWritting;

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

    public int getYearOfWritting() {
        return yearOfWritting;
    }

    public void setYearOfWritting(int yearOfWritting) {
        this.yearOfWritting = yearOfWritting;
    }

    public Book(String author, String name, int yearOfWritting ) {
        this.author = author;
        this.name = name;
        this.yearOfWritting = yearOfWritting;
    }
}
