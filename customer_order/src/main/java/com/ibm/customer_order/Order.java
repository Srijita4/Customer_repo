package com.ibm.customer_order;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn; 
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="Orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OrderId")
	private String OrderId;
	
	@Column(name="OrderType")
	private String OrderType;
	
	@Column(name="Price")
	private double Price;
	
	@Column(name="IsConfirmed")
	private boolean IsConfirmed;
	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CustomerId")
	private Customer customer;*/
	public Order(String orderId, double orderPrice, Boolean isConfirmed) {
		super();
		this.OrderId = orderId;
		this.Price = orderPrice;
		this.IsConfirmed = isConfirmed;
	}
	
	
	
	

}
