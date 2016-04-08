package cn.itcast.web.controller;

import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.Formbean;
import cn.itcast.domain.User;
import cn.itcast.exceptions.UserexitException;
import cn.itcast.service.impl.BussinessServiceImpl;
import sun.misc.UUEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        // 1,获得表单提交数据,对数据进行校验.
        Formbean form = new Formbean();
        form.setUsername(request.getParameter("username"));
        form.setPassword1(request.getParameter("password1"));
        form.setPassword2(request.getParameter("password2"));
        form.setEmail(request.getParameter("email"));
        form.setNickname(request.getParameter("nickname"));
        form.setBirthday(request.getParameter("birthday"));

        boolean b = form.checkform(request);

        //2,校验失败,跳回主业页面,回写错误信息.
        if (b == false) {
            request.setAttribute("form", form);
            request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
            return;
        } else {

            User user=new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password1"));
        user.setEmail(request.getParameter("email"));
        user.setNickname(request.getParameter("nickname"));
        try {
            String birthday = (request.getParameter("birthday"));
            if (birthday == null || birthday.trim().equals("")) {
                user.setBirthday(null);
            } else {

                user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
            }
        } catch (ParseException e) {
            System.out.println("日期转换失败");
        }


        /*3,校验成功,调用server层处理注册请求*/
   BussinessServiceImpl serv= new BussinessServiceImpl();

        try {
            serv.register(user);
           /* 4,注册失败,由于用户名已存在,跳回注册页面,回写错误信息*/
        } catch (UserexitException e) {
            form.getErrors().put("username", "用户名已存在");
            request.setAttribute("form", form);
            request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
            return;
        } catch (Exception e) {
//        /*5,注册失败,其他原因,跳到全局显示页面*/
            response.sendRedirect("/error");
            return;
        }

        /*6,注册成功,跳到主页让用户登录.*/
        response.getWriter().write("注册成功! 3秒后转到登录页面!");
            response.sendRedirect("/index.jsp");
        }
    }
}
