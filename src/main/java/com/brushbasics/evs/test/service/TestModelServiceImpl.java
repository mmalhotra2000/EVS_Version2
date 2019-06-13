package com.brushbasics.evs.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brushbasics.evs.ObjectMapperUtils;
import com.brushbasics.evs.test.dao.TestModelDAO;
import com.brushbasics.evs.test.dto.UserDetailsDTO;
import com.brushbasics.evs.test.dto.UserVehReqDTO;
import com.brushbasics.evs.test.dto.VehicleDTO;
import com.brushbasics.evs.test.model.TestModel;
import com.brushbasics.evs.test.model.UserDetails;

@Service
@Transactional
public class TestModelServiceImpl implements TestModelService {

	@Autowired
	private TestModelDAO testModelDAO;

	@Override
	public void saveTestModel(TestModel testModel) {
		testModelDAO.saveTestModel(testModel);
	}

	@Override
	public List<TestModel> getAllTest() {
		return testModelDAO.findAll();
	}

	@Override
	public void saveUserDetails(UserDetails userDetails) {
		testModelDAO.saveUserDetails(userDetails);
	}

	@Override
	public UserDetailsDTO getUserDetailsByName(String name) {
		UserDetails userDetails= testModelDAO.getUserDetailsByName(name);
		UserDetailsDTO userDetailsDTO = ObjectMapperUtils.map(userDetails,
				UserDetailsDTO.class);
		List<VehicleDTO> vehicleDTOs  = ObjectMapperUtils.mapAll(userDetails.getVehicles(), VehicleDTO.class);
		userDetailsDTO.setVehicleDTOs(vehicleDTOs);
		return userDetailsDTO;
	}

	@Override
	public void saveUpdateUserDetailsAndVeh(List<UserVehReqDTO> userVehReqDTOs) {
		testModelDAO.saveUpdateUserDetailsAndVeh(userVehReqDTOs);
	}

}
