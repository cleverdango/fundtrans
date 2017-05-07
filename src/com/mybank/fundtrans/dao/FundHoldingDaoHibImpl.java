package com.mybank.fundtrans.dao;

import java.io.Serializable;
import java.util.List;

import com.mybank.fundtrans.domain.FundHolding;

public class FundHoldingDaoHibImpl extends BaseDaoImpl<FundHolding> implements FundHoldingDao {

	@Override
	public FundHolding find(int fundId, int accId) {
		// TODO Auto-generated method stub
		String hql = "from FundHolding as fh where fh.fund.id=?0 and fh.finAcc.id=?1";
		List fundHolds = find(hql, fundId, accId);
		if (fundHolds.size() == 0)
			return null;
		else
			return (FundHolding) fundHolds.get(0);
	}

	@Override
	public List findByAcc(int accNo, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from FundHolding as fh where fh.finAcc.id=?0";
		List fundHolds=findByPage(hql, pageNo, pageSize, accNo);
		return fundHolds;
	}
}
