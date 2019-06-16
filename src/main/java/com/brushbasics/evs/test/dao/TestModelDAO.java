package com.brushbasics.evs.test.dao;

import java.util.List;

import com.brushbasics.evs.CustomException;
import com.brushbasics.evs.test.dto.UserVehReqDTO;
import com.brushbasics.evs.test.model.TestModel;
import com.brushbasics.evs.test.model.UserDetails;

public interface TestModelDAO {

	List<TestModel> findAll();

	void saveTestModel(TestModel testModel);

	void saveUserDetails(UserDetails userDetails) throws CustomException;

	UserDetails getUserDetailsByName(String name) throws CustomException;
	
	public void saveUpdateUserDetailsAndVeh(List<UserVehReqDTO> userVehReqDTOs);

	Object getUserNativeQuery(String where, String name, long seq);

	UserDetails getUserDetailsByNameAndWhere(String where, String name, long seq) throws CustomException;


}
