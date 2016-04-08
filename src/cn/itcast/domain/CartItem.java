package cn.itcast.domain;
//标识 某个商品,及商品出现的次数(购物项)


public class CartItem {
    private Book book;
    private int quantity;
    private double price;


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        //每次调用更新书的数量,就会相应更新价格
        this.price=this.getQuantity()*book.getPrice();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
