package com.mybank.fundtrans.controller;

import com.mybank.fundtrans.dao.UserDao;
import com.mybank.fundtrans.dao.UserDaoJDBCImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yazawanico on 2017/3/20.
 */
@WebServlet("/User")
class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        switch (type) {

            case "1":
                //1.获取表单参数
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                //2.创建dao或者service对象
                UserDao userDao = new UserDaoJDBCImpl();
                boolean flag = userDao.validate(userName, password);
                if (flag) {
                    //3.把用户名放入session中
                    HttpSession session = request.getSession();
                    session.setAttribute("user", userName);
                    //4.请求转发到jsp
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;
            case "2":
                request.getSession().removeAttribute("user");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
