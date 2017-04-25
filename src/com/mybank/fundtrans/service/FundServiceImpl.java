package com.mybank.fundtrans.service;

import com.mybank.fundtrans.dao.FundDao;
import com.mybank.fundtrans.dao.FundDaoHibImpl;
import com.mybank.fundtrans.dao.FundDaoJDBCImpl;
import com.mybank.fundtrans.util.PageBean;

public class FundServiceImpl implements FundService {
    //private FundDao fundDao = new FundDaoJDBCImpl();
        private FundDao fundDao = new FundDaoHibImpl();
    @Override
    public PageBean getFunds(int pageNo) {
        // TODO Auto-generated method stub
        fundDao.findRowCount();
        PageBean pageBean = new PageBean();
        pageBean.data = fundDao.findByPage(pageNo, pageBean.rowsPerPage);
        pageBean.curPage = pageNo;
        pageBean.maxRowCount = fundDao.findRowCount();
        pageBean.countMaxPage();
        return pageBean;
    }

}
