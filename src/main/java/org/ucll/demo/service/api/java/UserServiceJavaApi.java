package org.ucll.demo.service.api.java;

import org.ucll.demo.domain.BmiUser;
import org.ucll.demo.service.UserService;
import org.ucll.demo.service.api.java.assembler.UserToAssembler;
import org.ucll.demo.service.api.java.to.UserDetail;

public class UserServiceJavaApi {
	private UserService personService;
	private UserToAssembler personToAssembler;

	public UserServiceJavaApi(){
		//TODO use CDI, ...
		personService = new UserService();
		personToAssembler = new UserToAssembler();
	}
	
	public void addPerson(UserDetail personDetail) {
		BmiUser person = personToAssembler.createUser(personDetail);
		getPersonService().addPerson(person);
	}

	public UserDetail getPerson(String id) {
		BmiUser person = getPersonService().getPerson(id);
		if (person == null) {
			throw new IllegalArgumentException("error.person.not.found");
		}
		return personToAssembler.creatUserDetailTo(person);
	}

	public void deletePerson(String id){
		getPersonService().deletePerson(id);
	}
	
	protected UserService getPersonService() {
		return personService;
	}

	protected void setPersonService(UserService personService) {
		this.personService = personService;
	}
}
