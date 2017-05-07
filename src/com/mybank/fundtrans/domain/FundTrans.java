package com.mybank.fundtrans.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fund_transinfo")
public class FundTrans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 交易流水号
	private String type; // 交易类型
	// private int accId; // 交易账户
	// private int fundId; // 交易基金
	private int amount; // 交易基金份数
	private double price; // 交易单价
	private Date createTime; // 交易时间

	@ManyToOne
	@JoinColumn(name = "fundId")
	private Fund fund;

	@ManyToOne
	@JoinColumn(name = "accId")
	private FinAcc finAcc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
