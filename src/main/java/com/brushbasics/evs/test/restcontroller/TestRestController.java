package com.brushbasics.evs.test.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brushbasics.evs.test.dto.UserDetailsDTO;
import com.brushbasics.evs.test.dto.UserVehReqDTO;
import com.brushbasics.evs.test.model.UserDetails;
import com.brushbasics.evs.test.model.Vehicle;
import com.brushbasics.evs.test.service.TestModelService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/rest")
public class TestRestController {

	@Autowired
	private TestModelService testModelServiceImpl;

	@GetMapping(path = "/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping(path = "/save")
	public void save() {

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName("veh1");
		vehicle1.setColor("green");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName("veh2");
		vehicle2.setColor("blue");

		UserDetails userDetails = new UserDetails();
		userDetails.setName("test1");

		vehicle1.setUserDetails(userDetails);
		vehicle2.setUserDetails(userDetails);

		userDetails.setVehicles(Arrays.asList(vehicle1, vehicle2));

		testModelServiceImpl.saveUserDetails(userDetails);
	}

	@GetMapping(path = "/users/{name}")
	public MappingJacksonValue getAllUsers(@PathVariable("name") String name) {

		UserDetailsDTO userDetailsDTO = testModelServiceImpl.getUserDetailsByName(name);

		// create filter
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("seq", "userDetails");
		// create filter
		SimpleBeanPropertyFilter filter1 = SimpleBeanPropertyFilter.filterOutAllExcept("name", "vehicleDTOs");

		// create filter provider
		FilterProvider filters = new SimpleFilterProvider().addFilter("vehicleFilter", filter).addFilter("userDetailsFilter", filter1);

		// Create mapping jackson abject to serialize and set/apply filters to user bean

		MappingJacksonValue mapping = new MappingJacksonValue(userDetailsDTO);

		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping(path = "/users//filter/{name}")
	public MappingJacksonValue getAllFilteredUsers(@PathVariable("name") String name) {

		UserDetailsDTO userDetailsDTO = testModelServiceImpl.getUserDetailsByName(name);

		// create filter
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("seq", "userDetails","color");
		// create filter
		SimpleBeanPropertyFilter filter1 = SimpleBeanPropertyFilter.filterOutAllExcept("name", "vehicleDTOs");

		// create filter provider
		FilterProvider filters = new SimpleFilterProvider().addFilter("vehicleFilter", filter).addFilter("userDetailsFilter", filter1);

		// Create mapping jackson abject to serialize and set/apply filters to user bean

		MappingJacksonValue mapping = new MappingJacksonValue(userDetailsDTO);

		mapping.setFilters(filters);
		return mapping;
	}
	
	@PutMapping("/usersave")
	public void saveOrUpdateUser(@RequestBody List<UserVehReqDTO> userVehReqDTOs) {
		testModelServiceImpl.saveUpdateUserDetailsAndVeh(userVehReqDTOs);
	}
	

}
