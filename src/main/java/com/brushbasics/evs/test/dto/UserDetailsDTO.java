package com.brushbasics.evs.test.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("userDetailsFilter")
public class UserDetailsDTO {

	private long seq;
	private String name;
	private List<VehicleDTO> vehicleDTOs;
	
	

	public UserDetailsDTO() {
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

	public List<VehicleDTO> getVehicleDTOs() {
		return vehicleDTOs;
	}

	public void setVehicleDTOs(List<VehicleDTO> vehicleDTOs) {
		this.vehicleDTOs = vehicleDTOs;
	}

	public UserDetailsDTO(long seq, String name, List<VehicleDTO> vehicleDTOs) {
		super();
		this.seq = seq;
		this.name = name;
		this.vehicleDTOs = vehicleDTOs;
	}

}
