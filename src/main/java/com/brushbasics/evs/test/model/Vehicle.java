package com.brushbasics.evs.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="vehicle")
public class Vehicle extends BaseModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long seq;
	private String name;
	private String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetails userDetails;
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(long seq, String name, UserDetails userDetails) {
		super();
		this.seq = seq;
		this.name = name;
		this.userDetails = userDetails;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	

}
