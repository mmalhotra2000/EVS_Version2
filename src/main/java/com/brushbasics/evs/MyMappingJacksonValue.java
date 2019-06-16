package com.brushbasics.evs;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;

public class MyMappingJacksonValue<T extends MappingJacksonValue> {
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public MyMappingJacksonValue(T value, FilterProvider filters,MappingJacksonValue mapping) {
		mapping.setFilters(filters);
	}

}
