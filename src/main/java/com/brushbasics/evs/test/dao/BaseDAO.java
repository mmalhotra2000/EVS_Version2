package com.brushbasics.evs.test.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brushbasics.evs.test.model.BaseModel;

@Repository
public abstract class BaseDAO {

	@Autowired
	protected SessionFactory sessionFactory;

	protected <T extends BaseModel> void save(T obj) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(obj);
		session.flush();

	}

	protected <T extends BaseModel> void saveOrUpdate(T obj) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(obj);

	}

	protected <T extends BaseModel, I extends Serializable> Object get(Class<T> clazz, I id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(clazz, id);
	}

	protected <T extends BaseModel> void update(T obj) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(obj);
		session.flush();
	}

	protected <T extends BaseModel> void delete(T obj) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(obj);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	protected <T extends BaseModel> List<T> findAll(Class<T> clazz) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(clazz);
		Root<T> root = query.from(clazz);
		query.select(root);
		Query q = session.createQuery(query);
		return q.getResultList();
	}

}