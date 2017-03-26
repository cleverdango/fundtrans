package com.mybank.fundtrans.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mybank.fundtrans.dao.UserDao;
import com.mybank.fundtrans.dao.UserDaoJDBCImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
	 * servlet作为控制器处理流程： 1. 获取请求参数; 2. 调用dao或者service对象处理; 3.
	 * 把数据对象存储到request范围中; 4. 请求转发到jsp或者servlet。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoJDBCImpl();
		String type=request.getParameter("type");
		switch (type) {
		case "1"://处理登录验证
			//1. 获取表单参数
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			//2. 创建dao或者service对象
			boolean flag=userDao.validate(userName, password);
			
			if (flag) {
				//3. 把用户名放入session中
				HttpSession session=request.getSession();
				session.setAttribute("user", userName);
				//4.请求转发到jsp
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else
				request.getRequestDispatcher("login.jsp").forward(request, response);
			break;

		case "2"://处理退出
			request.getSession().removeAttribute("user");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		default:
			break;
		}
		
		

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
