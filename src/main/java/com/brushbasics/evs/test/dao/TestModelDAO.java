package com.brushbasics.evs.test.dao;

import java.util.List;

import com.brushbasics.evs.test.dto.UserVehReqDTO;
import com.brushbasics.evs.test.model.TestModel;
import com.brushbasics.evs.test.model.UserDetails;

public interface TestModelDAO {

	List<TestModel> findAll();

	void saveTestModel(TestModel testModel);

	void saveUserDetails(UserDetails userDetails);

	UserDetails getUserDetailsByName(String name);
	
	public void saveUpdateUserDetailsAndVeh(List<UserVehReqDTO> userVehReqDTOs);


}
