package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.FinAcc;

import java.util.List;

public interface FinAccDao {
	FinAcc findById(int id);  //按主键查找账户信息，返回FinAcc对象
	List findByCondition();
}
