package cn.itcast.domain;

public class Book {
    private String bookid;
    private String bookname;
    private String author;
    private String discription;
    private double price;

    public Book() {
    }

    public Book(String bookid, String bookname, String author, String discription, double price) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.discription = discription;
        this.price = price;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
