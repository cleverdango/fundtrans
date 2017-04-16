package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

/**
 * Created by yazawanico on 2017/4/16.
 */
public class FundDaoHibImpl implements FundDao {
    @Override
    public List findAll() {

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

    }

    @Override
    public void update(Fund fund) {

    }

    @Override
    public Fund findById(int fundNo) {
        return null;
    }

    @Override
    public List findByPage(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public int findRowCount() {
        return 0;
    }
}
