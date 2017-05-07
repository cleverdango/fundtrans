package com.mybank.fundtrans.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class FinAccDaoHibImplTest {
	private FinAccDao finAccDao=new FinAccDaoHibImpl();
	@Test
	public void testFindById() {
		finAccDao.findById(1);
		return;
	}
	
	//@Test
	public void testFindByCondition() {
		List finAccs=finAccDao.findByCondition();
		return;
	}

}
