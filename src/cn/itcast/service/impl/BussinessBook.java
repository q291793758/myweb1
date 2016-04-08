package cn.itcast.service.impl;

import cn.itcast.dao.impl.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;

import java.util.Map;

public class BussinessBook {

    private BookDao dao = new BookDao();

    public Map getAllBook() {
        return dao.getbooks();
    }


    public Book findBook(String bookname) {
        return dao.find(bookname);
    }

    //删除购物车cart中的购物项cartitem
    public void deleteCartItem(String id, Cart cart) {
        cart.getMap().remove(id);
    }

    public void changeItemQuantity(String id, String quantity, Cart cart) {
        CartItem item = cart.getMap().get(id);
        item.setQuantity(Integer.parseInt(quantity));

    }
}