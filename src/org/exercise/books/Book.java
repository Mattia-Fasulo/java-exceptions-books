package org.exercise.books;

public class Book {
    //ATTRIBUTES

    private String title;
    private String author;
    private String publisher;
    private int numPages;

    //CONSTRUCTOR
    public Book (String title, String author, String publisher, int numPages) throws IllegalArgumentException, NullPointerException {

        isNull(title ,"title");

        isNull(author, "author");

        isNull(publisher, "publisher");

        if (numPages <= 0){
            throw new IllegalArgumentException("number of pages cannot be equal to or less than 0");
        }

        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.numPages = numPages;



    }

    //METHODS
    private void isNull(String string, String field){
        if(string == null || string.length() == 0){
            throw new NullPointerException(field + " cannot be null");
        }
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numPages=" + numPages +
                '}';
    }
    //GETTER AND SETTER

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        isNull(title, "title");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        isNull(author, "author");
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        isNull(publisher, "publisher");
        this.publisher = publisher;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}
