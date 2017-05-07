package com.mybank.fundtrans.dao;

import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.mybank.fundtrans.domain.FinAcc;
import com.mybank.fundtrans.domain.FinAccTrans;
import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.HibernateUtil;
import java.util.List;

public class FinAccDaoHibImpl extends BaseDaoImpl<FinAcc> implements FinAccDao {

	@Override
	public FinAcc findById(int id) {
		// TODO Auto-generated method stub
		FinAcc finAcc = null;
		try {
			Session session = HibernateUtil.currentSession();
			finAcc = (FinAcc) session.get(FinAcc.class, id);
			System.out.println("交易情况:");
			Set<FinAccTrans> finAccTrans = finAcc.getFinAccTrans();
			for (FinAccTrans fat : finAccTrans) {
				System.out
						.println(fat.getId() + " " + fat.getType() + " " + fat.getAmount() + " " + fat.getCreateTime());
			}
			
			Set<Fund> funds=finAcc.getFunds();
			System.out.println("购买了以下这些基金:");
			for(Fund fund:funds ){
				System.out.println(fund.getName());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return finAcc;
	}

	@Override
	public List findByCondition() {
		// TODO Auto-generated method stub
		List finAccs = null;
		try {
			Session session = HibernateUtil.currentSession();
			String hql="from FinAcc as f left join f.client where f.id > ?0";
			Query query=session.createQuery(hql);
			query.setParameter("0", 1);
			finAccs=query.list();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return finAccs;
	}
	//@Autowired
	private SessionFactory sessionFactory;
	
	void insert(FinAcc finAcc){
		Session session=sessionFactory.getCurrentSession();
		session.save(finAcc);
	}
}
