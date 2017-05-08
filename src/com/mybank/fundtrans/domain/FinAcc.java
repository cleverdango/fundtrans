package com.mybank.fundtrans.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "financial_account")
public class FinAcc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; // 账户编号
	private String password; // 账户密码
	private Double amount; // 账号金额
	private String status; // 账户状态
	private String IDCard; // 客户ID
	private Date createTime; // 账户创建时间
	// 一对多 FinAccTrans
	@OneToMany(mappedBy = "finAcc", cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY) // 一对多
	// @Fetch(FetchMode.JOIN)
	private Set<FinAccTrans> finAccTrans = new HashSet();

	// 一对一 Client
	@OneToOne(targetEntity = Client.class)
	// 映射外键列
	@JoinColumn(name = "IDCARD", referencedColumnName = "IDCARD", unique = true)
	// name:本表中的外键， referencedColumnName：引用的另外一张表的列名
	private Client client;

	// 一对多 FundHolding
	@OneToMany(mappedBy="finAcc")
	private Set<FundHolding> fundHoldings = new HashSet<FundHolding>();

	// 多对多 Fund
	@ManyToMany()
	@JoinTable(name = "fund_holding", joinColumns = @JoinColumn(name = "accId"), inverseJoinColumns = @JoinColumn(name = "fundId"))
	private Set<Fund> funds = new HashSet<Fund>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set<FinAccTrans> getFinAccTrans() {
		return finAccTrans;
	}

	public void setFinAccTrans(Set<FinAccTrans> finAccTrans) {
		this.finAccTrans = finAccTrans;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Fund> getFunds() {
		return funds;
	}

	public void setFunds(Set<Fund> funds) {
		this.funds = funds;
	}

	public Set<FundHolding> getFundHoldings() {
		return fundHoldings;
	}

	public void setFundHoldings(Set<FundHolding> fundHoldings) {
		this.fundHoldings = fundHoldings;
	}
}
