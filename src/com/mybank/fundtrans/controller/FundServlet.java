package com.mybank.fundtrans.controller;

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

        String type = request.getParameter("type"); // step1
        FundDao fundDao = new FundDaoJDBCImpl();
        switch (type) {
            case "1":
                //add
                request.getRequestDispatcher("fund/fund_add.jsp").forward(request, response);
                break;
            case "2":
                //list
                List<Fund> funds = fundDao.findAll();  //step 2
                request.setAttribute("fundList", funds);// step 3
                request.getRequestDispatcher("fund/fund_list.jsp").forward(request, response); //step 4
                break;
            case "3":
                //update
                int fundId = Integer.parseInt(request.getParameter("id"));
                Fund  fund1 = fundDao.findById(fundId);
                request.setAttribute("fundUpdate",fund1);
                request.getRequestDispatcher("fund/fund_update.jsp").forward(request, response); //step 4
                break;
            case "4":
                //delete
                int fundId2 = Integer.parseInt(request.getParameter("id"));
                fundDao.delete(fundId2);
                List<Fund> funds2 = fundDao.findAll();  //step 2
                request.setAttribute("fundList", funds2);// step 3
                request.getRequestDispatcher("fund/fund_list.jsp").forward(request, response); //step 4
                break;
            case "5":
                //updateRes
                Integer fundId5 = Integer.parseInt(request.getParameter("fundId"));
                String fundName = request.getParameter("fundName");
                Double fundPrice = Double.valueOf(request.getParameter("fundPrice"));
                String fundDes = request.getParameter("fundDes");
                String fundStatus = request.getParameter("fundStatus");

                Fund fund3 = new Fund(fundId5,fundName,fundDes,fundPrice,fundStatus,new Date());

                fundDao.update(fund3);
                List<Fund> funds1 = fundDao.findAll();  //step 2
                request.setAttribute("fundList", funds1);// step 3
                request.getRequestDispatcher("fund/fund_list.jsp").forward(request, response); //step 4
                break;
            case "6":
                //addRes
                String fundName1 = request.getParameter("fundName");
                Double fundPrice1 = Double.valueOf(request.getParameter("fundPrice"));
                String fundDes1 = request.getParameter("fundDes");
                String fundStatus1 = request.getParameter("fundStatus");

                Fund fund = new Fund(0,fundName1,fundDes1,fundPrice1,fundStatus1,new Date());


                fundDao.insert(fund);
                List<Fund> funds3 = fundDao.findAll();
                request.setAttribute("fundList", funds3);// step 3
                request.getRequestDispatcher("fund/fund_list.jsp").forward(request, response); //step 4
                break;
            case "7":

            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
