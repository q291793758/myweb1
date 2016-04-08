package cn.itcast.domain;

import java.util.LinkedHashMap;
import java.util.Map;

//代表用户的购物车
public class Cart {
    private double totalprice;
    //为了避免购物车出现重复商品,Map<String,Book>不合适,需用一个特殊对象标识每种书的数量
   Map<String,CartItem> map= new LinkedHashMap();
    //购物车商品共计多少钱

    public void addbook(Book book) {
        //查看购物车中有没有要添加的书book相对应的购物项
        CartItem item = map.get(book.getBookid());
        if (item == null) {
            item = new CartItem();
            item.setBook(book);
            item.setQuantity(1);
            map.put(book.getBookid(), item);
        } else {
            item.setQuantity(item.getQuantity()+1);
        }
    }


    public void showlist() {

    }



    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    //计算总价格
    public double getTotalprice() {
        double price=0;
        for (Map.Entry<String, CartItem> entry:map.entrySet()){
            CartItem item = entry.getValue();
            price=price+item.getPrice();
        }
        this.totalprice=price;
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }


}