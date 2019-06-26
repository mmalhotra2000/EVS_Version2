package com.brushbasics.evs.test.model;

import java.sql.Timestamp;

public interface JPADataListenerClient {	
	
	public void setCreateUser(String createUser);
	
	public String getCreateUser();
	
	public void setModifyUser(String modifyUser);
	
	public String getModifyUser();
	
	public Timestamp getCreateDate();
	
	public void setCreateDate(Timestamp createDate);	
	
    public Timestamp getModifyDate();    
   
    public void setModifyDate(Timestamp modifyDate);	

}