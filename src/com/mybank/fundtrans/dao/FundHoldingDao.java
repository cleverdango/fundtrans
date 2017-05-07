package com.mybank.fundtrans.dao;

import java.util.List;

import com.mybank.fundtrans.domain.FundHolding;

public interface FundHoldingDao {
	FundHolding find(int fundId, int accId);
	List findByAcc(int accNo, int pageNo, int pageSize);
}
