package com.brushbasics.evs.test.dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class LeadDTO {
	
	private long seq;
	@Size(min=3,message="It should be minimum of 3")
	private String name;
	@Past
	private Date date;
	public LeadDTO(long seq, String name, Date date) {
		super();
		this.seq = seq;
		this.name = name;
		this.date = date;
	}
	public LeadDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
