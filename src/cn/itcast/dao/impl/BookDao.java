package cn.itcast.dao.impl;

import cn.itcast.domain.Book;
import cn.itcast.domain.BookDB;

import java.util.Map;

public class BookDao {

    public Map getbooks() {
        return BookDB.getAll();
    }

    public Book find(String id) {
        return (Book) BookDB.getAll().get(id);
    }
    
}
