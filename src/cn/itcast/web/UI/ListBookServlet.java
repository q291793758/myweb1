package cn.itcast.web.UI;

import cn.itcast.service.impl.BussinessBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
//跳转到显示所有商品的页面
public class ListBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BussinessBook bussinessBook = new BussinessBook();
        Map bookmap= bussinessBook.getAllBook();
        request.setAttribute("bookmap",bookmap);

        request.getRequestDispatcher("WEB-INF/jsp/BookStore.jsp").forward(request,response);
    }
}
