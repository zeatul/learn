package com.hawk.utility.example.jsr303.example1;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Order {
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	// 必须不为 null, 大小是 10
	@NotNull
	@Size(min = 10, max = 10)
	private String orderId;
	// 必须不为空
	@NotEmpty
	private String customer;
	// 必须是一个电子信箱地址
	@Email
	private String email;
	// 必须不为空
	@NotEmpty
	@Size(min=0,max=100)
	private String address;
	// 必须不为 null, 必须是下面四个字符串'created', 'paid', 'shipped', 'closed'其中之一
	// @Status 是一个定制化的 contraint
	@NotNull
	@Status
	private String status;
	// 必须不为 null
	@NotNull
	private Date createDate;
	// 嵌套验证
	@Valid
	private Product product;
}
