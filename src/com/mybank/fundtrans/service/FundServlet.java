package com.mybank.fundtrans.service;

import com.mybank.fundtrans.dao.FundDao;
import com.mybank.fundtrans.dao.FundDaoJDBCImpl;
import com.mybank.fundtrans.domain.Fund;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by yazawanico on 2017/3/19.
 */
@WebServlet("/Fund")
public class FundServlet extends HttpServlet {
    /**
     * 1. 获取请求参数
     * 2. 调用dao或者service对象处理
     * 3. 把数据对象存储到request范围中
     * 4. 请求转发到jsp或者servlet
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type"); // step1
        switch (type) {
            case "1":
                //add
                request.getRequestDispatcher("fund/fund_add.jsp").forward(request, response);
                break;
            case "2":
                //list
                FundDao fundDao = new FundDaoJDBCImpl();
                List<Fund> funds = fundDao.findAll();  //step 2
                request.setAttribute("fundList", funds);// step 3
                request.getRequestDispatcher("fund/fund_list.jsp").forward(request, response); //step 4
                break;
            case "3":
                //update
                int fundId = Integer.parseInt(request.getParameter("id"));
                FundDao fundDao1 = new FundDaoJDBCImpl();
                Fund  fund1 = fundDao1.findById(fundId);
                request.setAttribute("fundUpdate",fund1);
                request.getRequestDispatcher("fund/fund_update.jsp").forward(request, response); //step 4
                break;
            case "4":
                //delete
                int fundId2 = Integer.parseInt(request.getParameter("id"));
                FundDao fundDao2 = new FundDaoJDBCImpl();
                Fund fund2 = fundDao2.findById(fundId2);
                request.setAttribute("fundDelete",fund2);
                request.getRequestDispatcher("fund/fund_delete.jsp").forward(request, response); //step 4
                break;
            case "5":
                //updateRes
                Integer fundId5 = Integer.parseInt(request.getParameter("fundId"));
                String fundName = request.getParameter("fundName");
                Double fundPrice = Double.valueOf(request.getParameter("fundPrice"));
                String fundDes = request.getParameter("fundDes");
                String fundStatus = request.getParameter("fundStatus");
                FundDao fundDao3 = new FundDaoJDBCImpl();
                Fund fund3 = new Fund(fundId5,fundName,fundDes,fundPrice,fundStatus,new Date());
                fundDao3.update(fund3);
                List<Fund> funds1 = fundDao3.findAll();  //step 2
                request.setAttribute("fundList", funds1);// step 3
                request.getRequestDispatcher("fund/fund_list.jsp").forward(request, response); //step 4
                break;
            case "6":
                //addRes

                break;

            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
