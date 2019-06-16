package com.brushbasics.evs.test.dto;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonFilter("vehicleFilter")
public class VehicleDTO {
	private long seq;
	private String name;
	private String color;

	private UserDetailsDTO userDetailsDTO;

	public VehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleDTO(long seq, String name, UserDetailsDTO userDetailsDTO) {
		super();
		this.seq = seq;
		this.name = name;
		this.userDetailsDTO = userDetailsDTO;
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

	public UserDetailsDTO getUserDetailsDTO() {
		return userDetailsDTO;
	}

	public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
		this.userDetailsDTO = userDetailsDTO;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
