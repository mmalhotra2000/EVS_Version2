package com.brushbasics.evs.test.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class BaseEntityListener {

	@PreUpdate
	public void postLoaded(JPADataListenerClient client) {
		// String userName = JPADataHolder.getUserName();

		client.setModifyUser("Mohit");
		client.setCreateDate(new Timestamp(new Date().getTime()));

	}

	/**
	 * This method will be used to set createUser, modifiedUser, createDate and
	 * modified date before saving of an entity in database
	 * 
	 * @param client
	 */
	@PrePersist
	public void prePersist(JPADataListenerClient client) {
		// String userName = JPADataHolder.getUserName();

		client.setModifyUser("Mohit");
		client.setCreateDate(new Timestamp(new Date().getTime()));
	}

}
