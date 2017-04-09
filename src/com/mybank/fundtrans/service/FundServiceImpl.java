package com.mybank.fundtrans.service;

import com.mybank.fundtrans.dao.FundDao;
import com.mybank.fundtrans.dao.FundDaoJDBCImpl;
import com.mybank.fundtrans.util.PageBean;

public class FundServiceImpl implements FundService {
	private FundDao fundDao=new FundDaoJDBCImpl();
	@Override
	public PageBean getFunds(int pageNo) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data=fundDao.findByPage(pageNo, pageBean.rowsPerPage);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=fundDao.findRowCount();
		pageBean.countMaxPage();
		return pageBean;
	}

}
