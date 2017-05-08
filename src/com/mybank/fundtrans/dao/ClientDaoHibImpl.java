package com.mybank.fundtrans.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mybank.fundtrans.domain.Client;
import com.mybank.fundtrans.util.HibernateUtil;
import org.hibernate.query.Query;

public class ClientDaoHibImpl implements ClientDao {

	@Override
	public List findAll() {
		Session session = HibernateUtil.currentSession();
		String hql = "from Client";
		Query query = session.createQuery(hql);
		List <Client> clients =query.list();
		return clients;
	}

	@Override
	public void insert(Client client) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(client);
		transaction.commit();
		HibernateUtil.closeSession();

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction transaction=session.beginTransaction();
		Client client = (Client) session.get(Client.class, id);
		session.delete(client);
		transaction.commit();
		HibernateUtil.closeSession();
	}

	@Override
	public void update(Client client) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction  = session.beginTransaction();
		Client clientupdate = session.get(Client.class, client.getIDCard());

		clientupdate.setName(client.getName());
		clientupdate.setSex(client.getSex());
		clientupdate.setAddress(client.getAddress());
		clientupdate.setEmail(client.getEmail());
		//clientupdate.setCreateTime(client.getCreateTime());
		//clientupdate.setFinAcc(client.getFinAcc());
		clientupdate.setHobby(client.getHobby());
		clientupdate.setPhone(client.getPhone());

		session.flush();
		transaction.commit();
		HibernateUtil.closeSession();

	}

	@Override
	public Client findById(String id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Client client = (Client) session.get(Client.class, id);
		HibernateUtil.closeSession();
		return client;
	}

}
