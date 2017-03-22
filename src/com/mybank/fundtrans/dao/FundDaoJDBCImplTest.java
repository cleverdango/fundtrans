package com.mybank.fundtrans.dao;

import static org.junit.Assert.*;

import java.util.Date;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import org.junit.Before;
import org.junit.Test;

import com.mybank.fundtrans.domain.Fund;

public class FundDaoJDBCImplTest {
	private FundDao fundDao = new FundDaoJDBCImpl();


	@Test
	public void testFindAll() {
		System.out.println(fundDao.findAll());
	}

	@Test
	public void testInsert() {
		Fund fund = new Fund(1008613, "团子基金3", "miaomiaomiao", 100.2, "Y", new Date());
		fundDao.insert(fund);
	}

	@Test
	public void testDelete() {
		fundDao.delete(46);
	}

	@Test
	public void testUpdate() {
		Fund fund = new Fund(39, "yazawa", "hHAHAHA", 11.0, "N", new Date());
		fundDao.update(fund);
	}

	@Test
	public void testFindById() {
		System.out.println("find:"+fundDao.findById(20));
	}

}
