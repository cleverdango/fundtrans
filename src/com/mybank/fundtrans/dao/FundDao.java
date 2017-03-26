package com.mybank.fundtrans.dao;
import java.sql.SQLException;
import java.util.List;
import com.mybank.fundtrans.domain.Fund;
/**
* Description: TODO
* @author 
* @date 2017年2月25日 下午2:57:56
 */
public interface FundDao {
	List findAll(); //获取所有的基金记录, Fund对象列表
	void insert(Fund fund);
	void delete(int fundNo);
	void update(Fund fund);
	Fund findById(int fundNo);

}
