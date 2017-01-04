package com.example.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ItemResDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer price;
	private Timestamp createAt;
	private Timestamp updateAt;
	
	public ItemResDto() {
	}
	public ItemResDto(Integer id, String name, Integer price, Timestamp createAt, Timestamp updateAt) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.createAt = createAt;
		this.updateAt = updateAt;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	public Timestamp getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
	
	
}
