package cn.itcast.web.controller;

import cn.itcast.domain.Cart;
import cn.itcast.service.impl.BussinessBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//把购物车cart中的书修改为指定数量quantity
public class ChangeQuantityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");
        String quantity=request.getParameter("quantity");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        BussinessBook bussinessBook=new BussinessBook();
        bussinessBook.changeItemQuantity(id,quantity,cart);
        request.getRequestDispatcher("/ListCartServlet").forward(request,response);

    }
}
