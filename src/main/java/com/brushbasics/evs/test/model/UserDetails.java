package com.brushbasics.evs.test.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
		@NamedQuery(name = "UserDetails.getUserByName", query = "select u from userdetails u where u.name = ?1") })
@Entity(name = "userdetails")
public class UserDetails extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long seq;
	private String name;
	@OneToMany(mappedBy = "userDetails", fetch = FetchType.LAZY)
	private List<Vehicle> vehicles;

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(long seq, String name, List<Vehicle> vehicles) {
		super();
		this.seq = seq;
		this.name = name;
		this.vehicles = vehicles;
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

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
