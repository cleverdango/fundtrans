package com.mybank.fundtrans.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "financial_account_transinfo")
public class FinAccTrans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 交易号
	private String type; // 交易类型
	private double amount; // 交易金额
	private Date createTime; // 交易时间
	// private int accId; 账户编号
	@ManyToOne( cascade = { javax.persistence.CascadeType.ALL })
	// 映射外键列
	@JoinColumn(name = "accId", referencedColumnName="id")
	private FinAcc finAcc; // 关联的

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public FinAcc getFinAcc() {
		return finAcc;
	}

	public void setFinAcc(FinAcc finAcc) {
		this.finAcc = finAcc;
	}
}
