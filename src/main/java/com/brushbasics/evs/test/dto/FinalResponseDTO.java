package com.brushbasics.evs.test.dto;

public class FinalResponseDTO<T> {
	
	private String result;
	private T data;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public FinalResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinalResponseDTO(String result, T data) {
		super();
		this.result = result;
		this.data = data;
	}
	

}
