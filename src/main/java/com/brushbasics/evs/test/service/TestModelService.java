package com.brushbasics.evs.test.service;

import java.util.List;

import com.brushbasics.evs.CustomException;
import com.brushbasics.evs.test.dto.UserDetailsDTO;
import com.brushbasics.evs.test.dto.UserVehReqDTO;
import com.brushbasics.evs.test.model.TestModel;
import com.brushbasics.evs.test.model.UserDetails;

public interface TestModelService {
	public void saveTestModel(TestModel testModel);

	public List<TestModel> getAllTest();
	
	void saveUserDetails(UserDetails userDetails) throws CustomException;

	public UserDetailsDTO getUserDetailsByName(String name) throws CustomException;

	public void saveUpdateUserDetailsAndVeh(List<UserVehReqDTO> userVehReqDTOs);

	Object getUserNativeQuery(String where, String name, long seq);
	
	UserDetails getUserDetailsByNameAndWhere(String where, String name, long seq) throws CustomException;


}
