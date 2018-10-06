package org.ucll.demo.service;

import java.util.List;

import org.ucll.demo.domain.BmiUser;
import org.ucll.demo.repository.UserRepository;
import org.ucll.demo.repository.UserStubRepository;

public class UserService {
	private UserRepository userRepository;

	public UserService() {
		//TODO Use CDI
		setUserRepository(new UserStubRepository());
	}

	public void addPerson(BmiUser person) {
		getUserRepository().add(person);
	}

	public BmiUser getPerson(String id) {
		return (BmiUser) getUserRepository().get(id);
	}

	public List<BmiUser> getPersons()  {
		return getUserRepository().getAll();
	}
	
	public void deletePerson(String id){
		getUserRepository().delete(id);
	}
	
	public BmiUser getUserIfAuthenticated(String personId, String password) {
		BmiUser person = getPerson(personId);
		
		if (person!= null && person.isCorrectPassword(password)) {
			return person;
		} else {
			return null;
		}
	}

	private void setUserRepository(UserRepository personDb) {
		this.userRepository = personDb;
	}

	protected UserRepository getUserRepository() {
		return userRepository;
	}
}
