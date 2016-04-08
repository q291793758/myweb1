package cn.itcast.web.controller;

import cn.itcast.domain.User;
import cn.itcast.service.impl.BussinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        BussinessServiceImpl service=new BussinessServiceImpl();
        User user = service.login(username, password);

        if (user == null) {
            request.setAttribute("username","用户名或密码错误!");
            request.getRequestDispatcher("index.jsp").forward(request,response);
            return;
        }else {
            response.getWriter().write("登录成功!");
            request.getSession().setAttribute("login",user.getNickname());
            request.getRequestDispatcher("/ListBookServlet").forward(request,response);
            return;
        }

    }
}
