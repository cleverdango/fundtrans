package com.mybank.fundtrans.dao;
import java.util.List;
import com.mybank.fundtrans.domain.Client;

public interface ClientDao {
	List findAll();    
	void insert(Client client);    
	void delete(String id);    
	void update(Client client);    
	Client findById(String id); 
}
