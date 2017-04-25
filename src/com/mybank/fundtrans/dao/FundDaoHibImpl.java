package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

import static com.mybank.fundtrans.util.HibernateUtil.session;

/**
 * Created by yazawanico on 2017/4/16.
 */

/**
 * 1.获取session对象
 * 2.开启事务
 * 3.开始增删改
 * 4.提交事务
 * 5.关闭session对象
 */
public class FundDaoHibImpl implements FundDao {
    @Override
    public List findAll() {

        Session session = HibernateUtil.currentSession();

        return null;
    }

    @Override
    public void insert(Fund fund) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(fund);
        transaction.commit();
        HibernateUtil.closeSession();

    }

    @Override
    public void delete(int fundNo) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();
        Fund fund = session.get(Fund.class, fundNo);
        session.delete(fund);
        transaction.commit();
        HibernateUtil.closeSession();

    }

    @Override
    public void update(Fund fund) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();
        Fund fundupdate = session.get(Fund.class, fund.getId());
        fundupdate.setName(fund.getName());
        fundupdate.setPrice(fund.getPrice());
        fundupdate.setDescription(fund.getDescription());
        fundupdate.setStatus(fund.getStatus());
        session.flush();
        transaction.commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Fund findById(int fundNo) {
        Session session = HibernateUtil.currentSession();
        Fund fund = session.get(Fund.class, fundNo);
        HibernateUtil.closeSession();
        return fund;
    }

    @Override
    public List findByPage(int pageNo, int pageSize) {
        Session session = HibernateUtil.currentSession();
        String hql = "from Fund";
        return session.createQuery(hql).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();


    }

    @Override
    public int findRowCount() {
        Integer count = 0;
        String hql = "select count(*) from Fund";
        Session session = HibernateUtil.currentSession();
        Query q = session.createQuery(hql);
        List list = q.getResultList();
        count = new Long((long)list.get(0)).intValue();
        return count;
    }
}
