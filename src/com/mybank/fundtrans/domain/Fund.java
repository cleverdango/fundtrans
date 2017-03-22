package com.mybank.fundtrans.domain;

import java.util.Date;

public class Fund {
	private Integer id;
	private String name;
	private String description;
	private Double price;
	private String status;
	private Date createTime;
	
	
	public Fund() {
		super();
	}
	public Fund(Integer id, String name, String description, Double price, String status, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
		this.createTime = createTime;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Fund [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", status="
				+ status + ", createTime=" + createTime + "]"+"\n";
	}
	
	

}
