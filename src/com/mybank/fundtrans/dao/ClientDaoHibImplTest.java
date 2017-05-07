package com.mybank.fundtrans.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mybank.fundtrans.domain.Client;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ClientDaoHibImplTest {
	ClientDao clientDao=new ClientDaoHibImpl();
	@Test
	public void testFindAll() {
		//fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
		clientDao.delete("444444444444444444");
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		//fail("Not yet implemented");
		Client client=clientDao.findById("111111111111111111");
		return;
	}

}
