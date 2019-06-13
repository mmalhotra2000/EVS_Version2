package com.brushbasics.evs.test.dto;

public class UserVehReqDTO {
	
	private long useq;
	private String uname;
	private long vseq;
	public UserVehReqDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVehReqDTO(long useq, String uname, long vseq) {
		super();
		this.useq = useq;
		this.uname = uname;
		this.vseq = vseq;
	}
	public long getUseq() {
		return useq;
	}
	public void setUseq(long useq) {
		this.useq = useq;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public long getVseq() {
		return vseq;
	}
	public void setVseq(long vseq) {
		this.vseq = vseq;
	}
	
	
	
	

}
