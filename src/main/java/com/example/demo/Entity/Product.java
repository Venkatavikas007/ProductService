package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long pid;
	private String pname;
	private Integer pprice;
	
	public Product() {
		
	}

	public Product(Long pid, String pname, Integer pprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPprice() {
		return pprice;
	}

	public void setPprice(Integer pprice) {
		this.pprice = pprice;
	}
	
	
}
