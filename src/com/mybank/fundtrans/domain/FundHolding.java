package com.mybank.fundtrans.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  //实体类
@Table(name="fund_holding")  //对应的表
public class FundHolding {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; // 持仓ID
	private int amount; // 交易基金份数
	
	//多对一Fund
	@ManyToOne(targetEntity=Fund.class) 
	@JoinColumn(name="fundId", nullable=false)
	private Fund fund;
	
	//多对一FinAcc
	@ManyToOne(targetEntity=FinAcc.class)
	@JoinColumn(name="accId",nullable=false)
	private FinAcc finAcc;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Fund getFund() {
		return fund;
	}
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	public FinAcc getFinAcc() {
		return finAcc;
	}
	public void setFinAcc(FinAcc finAcc) {
		this.finAcc = finAcc;
	}
	
}
