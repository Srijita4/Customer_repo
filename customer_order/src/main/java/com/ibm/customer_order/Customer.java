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
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Customer")
@Data
public class Customer {
	@Id
	
	@Column(name = "CustomerId")
	private String CustomerId;
	@Column(name = "CustomerName")
	private String CustomerName;
	/*
	 * @Column(name ="CustomerOrderId") private String CustomerOrderId;
	 */
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CustomerOrderId")
	private Order order;
	
	public Customer(String CustomerId, String CustomerName) {
		super();
		this.CustomerId=CustomerId;
		this.CustomerName = CustomerName;
		
}
}

