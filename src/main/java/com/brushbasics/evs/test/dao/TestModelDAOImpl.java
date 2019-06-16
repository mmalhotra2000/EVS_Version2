package com.brushbasics.evs.test.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brushbasics.evs.CustomException;
import com.brushbasics.evs.test.dto.UserVehReqDTO;
import com.brushbasics.evs.test.model.TestModel;
import com.brushbasics.evs.test.model.UserDetails;

@Repository

public class TestModelDAOImpl extends BaseDAO implements TestModelDAO {

	@Override
	public List<TestModel> findAll() {
		return findAll(TestModel.class);
	}

	@Override
	public void saveTestModel(TestModel testModel) {
		saveOrUpdate((testModel));
	}

	@Override
	public void saveUserDetails(UserDetails userDetails)  throws CustomException{
		save(userDetails);
		userDetails.getVehicles().stream().forEach(veh->save(veh));
	}

	@Override
	public UserDetails getUserDetailsByName(String name) throws CustomException{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNamedQuery("UserDetails.getUserByName");
		query.setParameter(1, name);
		return (UserDetails) query.getSingleResult();
		
	}

	@Override
	public void saveUpdateUserDetailsAndVeh(List<UserVehReqDTO> userVehReqDTOs) {
		userVehReqDTOs.stream().forEach(user->{
			UserDetails userDetails = (UserDetails) get(UserDetails.class, user.getUseq());	
			userDetails.setName(user.getUname());
			saveOrUpdate((userDetails));
		});
		
	}
	
	@Override
	public Object getUserNativeQuery(String where , String name, long seq) {
		String query  =  "Select seq, name from userdetails "+where; // where seq = ?1 and name = ?2
		Query query2 = sessionFactory.getCurrentSession().createNativeQuery(query);
		query2.setParameter(1, seq);
		query2.setParameter(2, name);
		return query2.getResultList();
	}
	
	@Override
	public UserDetails getUserDetailsByNameAndWhere(String where , String name, long seq) throws CustomException{
		Session session = sessionFactory.getCurrentSession();
		String  qeurtt= "select u from userdetails u "+where;
		Query query2 = session.createQuery(qeurtt, UserDetails.class);
		query2.setParameter(1, seq);
		query2.setParameter(2, name);
		return (UserDetails) query2.getSingleResult();
		
	}

}
