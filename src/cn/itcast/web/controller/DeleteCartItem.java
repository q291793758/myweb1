package cn.itcast.web.controller;
//购物车中删除某个商品的servlet
import cn.itcast.domain.Cart;
import cn.itcast.service.impl.BussinessBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCartItem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        String id = request.getParameter("id");
        BussinessBook service=new BussinessBook();
        service.deleteCartItem(id,cart);
        response.sendRedirect("/ListCartServlet");
    }
}
