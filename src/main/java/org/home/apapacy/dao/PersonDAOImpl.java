package org.home.apapacy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.home.apapacy.models.PersonModel;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public void addPerson(PersonModel p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	@Transactional
	public void updatePerson(PersonModel p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PersonModel> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<PersonModel> personsList = session.createQuery("from Person").list();
		for(PersonModel p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	@Transactional
	public PersonModel getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		PersonModel p = (PersonModel) session.load(PersonModel.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		PersonModel p = (PersonModel) session.load(PersonModel.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}