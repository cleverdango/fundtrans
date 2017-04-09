package com.mybank.fundtrans.controller;

import com.mybank.fundtrans.dao.FundDao;
import com.mybank.fundtrans.dao.FundDaoJDBCImpl;
import com.mybank.fundtrans.domain.Fund;

/**
 * Created by yazawanico on 2017/4/9.
 */
public class FundAction  extends ActionSupport{
    private Fund fund;
    private PageBean fundList;
    private  Integer pageNo=1;
    private FundDao fundDao = new FundDaoJDBCImpl();
    //处理新增基金请求
    public  String add(){
        Fund
    }
}
