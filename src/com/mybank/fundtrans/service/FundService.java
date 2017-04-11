package com.mybank.fundtrans.service;
import com.mybank.fundtrans.util.PageBean;

public interface FundService {
	PageBean getFunds(int pageNo);  //根据页码，返回PageBean对象
}
