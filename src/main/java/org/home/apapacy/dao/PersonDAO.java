package org.home.apapacy.dao;

import java.util.List;
import org.home.apapacy.models.PersonModel;

public interface PersonDAO {
	public void addPerson(PersonModel p);
	public void updatePerson(PersonModel p);
	public List<PersonModel> listPersons();
	public PersonModel getPersonById(int id);
	public void removePerson(int id);
}