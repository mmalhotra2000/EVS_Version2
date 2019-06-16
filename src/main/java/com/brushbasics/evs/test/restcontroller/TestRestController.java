package com.brushbasics.evs.test.restcontroller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brushbasics.evs.CustomException;
import com.brushbasics.evs.ObjectMapperUtils;
import com.brushbasics.evs.test.dto.FinalResponseDTO;
import com.brushbasics.evs.test.dto.LeadDTO;
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
	public void save() throws CustomException {

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
	public MappingJacksonValue getAllUsers(@PathVariable("name") String name) throws CustomException {

		UserDetailsDTO userDetailsDTO = testModelServiceImpl.getUserDetailsByName(name);

		// create filter
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("seq", "userDetails");
		// create filter
		SimpleBeanPropertyFilter filter1 = SimpleBeanPropertyFilter.filterOutAllExcept("name", "vehicleDTOs");

		// create filter provider
		FilterProvider filters = new SimpleFilterProvider().addFilter("vehicleFilter", filter)
				.addFilter("userDetailsFilter", filter1);

		// Create mapping jackson abject to serialize and set/apply filters to user bean

		MappingJacksonValue mapping = new MappingJacksonValue(userDetailsDTO);

		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping(path = "/users/filter/{name}")
	public UserDetailsDTO getAllFilteredUsers(@PathVariable("name") String name) throws CustomException {

		UserDetailsDTO userDetailsDTO;
		try {
			userDetailsDTO = testModelServiceImpl.getUserDetailsByName(name);
		} catch (CustomException e) {
			throw new CustomException("This method para is not valid", e);
		}

		// create filter
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("seq", "userDetails", "color");
		// create filter
		SimpleBeanPropertyFilter filter1 = SimpleBeanPropertyFilter.filterOutAllExcept("name", "vehicleDTOs");

		// create filter provider
		FilterProvider filters = new SimpleFilterProvider().addFilter("vehicleFilter", filter)
				.addFilter("userDetailsFilter", filter1);

		// Create mapping jackson abject to serialize and set/apply filters to user bean

		MappingJacksonValue mapping = new MappingJacksonValue(userDetailsDTO);
		mapping.setFilters(filters);

		FinalResponseDTO finalResponseDTO = new FinalResponseDTO("success", mapping);
		return userDetailsDTO;
	}

	@PutMapping("/usersave")
	public void saveOrUpdateUser(@Valid @RequestBody List<UserVehReqDTO> userVehReqDTOs) {
		testModelServiceImpl.saveUpdateUserDetailsAndVeh(userVehReqDTOs);
	}

	@PostMapping("/createuser")
	public void createUserDetails(@Valid @RequestBody UserDetailsDTO userDetailsDTO) throws CustomException {
		UserDetails details = ObjectMapperUtils.map(userDetailsDTO, new UserDetails());
		Vehicle vehicle = ObjectMapperUtils.map(userDetailsDTO.getVehicleDTOs().get(0), new Vehicle());
		details.setVehicles(Arrays.asList(vehicle));
		try {
			testModelServiceImpl.saveUserDetails(details);
		} catch (CustomException e) {
			throw new CustomException("Somethig went wrong in method  createUserDetails() of class TestRestController" , e);
		}
	}

	@PostMapping("/savelead")
	public void createUserDetails(@Valid @RequestBody LeadDTO leadDTO) {

		System.out.println("done");
	}

}
