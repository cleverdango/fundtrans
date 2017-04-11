package com.mybank.fundtrans.controller;

import com.mybank.fundtrans.dao.FundDao;
import com.mybank.fundtrans.dao.FundDaoJDBCImpl;
import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.service.FundService;
import com.mybank.fundtrans.service.FundServiceImpl;
import com.mybank.fundtrans.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * Created by yazawanico on 2017/4/9.
 */
public class FundAction extends ActionSupport {
    private Fund fund;
    private PageBean fundList;
    private Integer pageNo = 1;
    private FundDao fundDao = new FundDaoJDBCImpl();

    //处理新增基金请求
    public String add() {
        fund.setCreateTime(new Date());
        fundDao.insert(fund);
        return SUCCESS;
    }

    //处理显示基金列表请求
    public String show() {
        FundService fundService = new FundServiceImpl();
        fundList = fundService.getFunds(pageNo);
        return "showFunds";
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public PageBean getFundList() {
        return fundList;
    }

    public void setFundList(PageBean fundList) {
        this.fundList = fundList;
    }
}
