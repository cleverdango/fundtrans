package com.mybank.fundtrans.controller;

import com.mybank.fundtrans.dao.ClientDao;
import com.mybank.fundtrans.dao.ClientDaoHibImpl;
import com.mybank.fundtrans.domain.Client;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * Created by yazawanico on 2017/5/7.
 */
public class ClientAction extends ActionSupport{
    private Client client;
    private String IDCard;
    private ClientDao clientDao = new ClientDaoHibImpl();

    public String add(){
        client.setCreateTime(new Date());
        clientDao.insert(client);
        return SUCCESS;
    }
    public String show(){
        clientDao.findAll();
        return "renderClientList";
    }
    public String delete(){
        clientDao.delete(client.getIDCard());
        return SUCCESS;
    }
    public String update(){
        clientDao.update(client);
        return "prepared";
    }
    public String preUpdate(){
        client = clientDao.findById(IDCard);
        return "prepared";

    }

    public Client getClient() {
        return client;
    }

    public String getIDCard() {
        return IDCard;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
}
