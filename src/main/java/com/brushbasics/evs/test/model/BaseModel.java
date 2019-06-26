package com.brushbasics.evs.test.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners({ BaseEntityListener.class })
@MappedSuperclass
public class BaseModel implements Serializable, JPADataListenerClient {

	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1136438170727147281L;

	/**
	 * when is this record been create
	 */
	protected Timestamp createDate;

	/**
	 * who creating the record
	 */
	protected String createUser;

	/**
	 * when is this record been updated
	 */
	protected Timestamp modifyDate;

	/**
	 * who make the last update
	 * 
	 */
	protected String modifyUser;

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

}