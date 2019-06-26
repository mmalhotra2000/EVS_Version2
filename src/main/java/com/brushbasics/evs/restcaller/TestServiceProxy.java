package com.brushbasics.evs.restcaller;


import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "dummy.restapiexample.com", url = "http://dummy.restapiexample.com")
public interface TestServiceProxy {
	
	//book/from/{source}/to/{dest}/date
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	public List<EmployeeResponse> getAllflightsFromBookingService();

	
}