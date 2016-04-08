package cn.itcast.web.controller;

import cn.itcast.domain.Book;
import cn.itcast.domain.BookDB;
import cn.itcast.domain.Cart;
import cn.itcast.service.impl.BussinessBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//完成书籍代码
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String bookid = request.getParameter("bookid");
        Book book =  new BussinessBook().findBook(bookid);

        //得到用户的购物车
        Cart cart= (Cart) request.getSession().getAttribute("cart");
        //把书加到购物车里
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        //把书加到购物车,完成购买.
        cart.addbook(book);
        //跳转显示购物车里的商品及数量,价格等信息


        //直接浏览器跳转 会导致刷新再买一本的情况
//        request.getRequestDispatcher("WEB-INF/jsp/listcart.jsp").forward(request,response);

        //通过servlet跳转到显示购物车WEB-INF/jsp/listcart.jsp;
        response.sendRedirect("/ListCartServlet");

    }
}
