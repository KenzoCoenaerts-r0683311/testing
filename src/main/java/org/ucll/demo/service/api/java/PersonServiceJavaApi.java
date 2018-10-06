package org.ucll.demo.service.api.java;

import java.util.List;

import org.ucll.demo.domain.BmiUser;
import org.ucll.demo.domain.Examination;
import org.ucll.demo.domain.Person;
import org.ucll.demo.service.PersonService;
import org.ucll.demo.service.UserService;
import org.ucll.demo.service.api.java.assembler.ExaminationToAssembler;
import org.ucll.demo.service.api.java.assembler.PersonToAssembler;
import org.ucll.demo.service.api.java.assembler.UserToAssembler;
import org.ucll.demo.service.api.java.to.ExaminationDetail;
import org.ucll.demo.service.api.java.to.PersonDetail;
import org.ucll.demo.service.api.java.to.PersonOverview;
import org.ucll.demo.service.api.java.to.UserDetail;

public class PersonServiceJavaApi {
	private PersonService personService;
	private UserService userService;
	private ExaminationToAssembler examinationToAssembler;
	private PersonToAssembler personToAssembler;
	private UserToAssembler userToAssembler;

	public PersonServiceJavaApi(){
		personService = new PersonService();
		examinationToAssembler = new ExaminationToAssembler();
		personToAssembler = new PersonToAssembler();

		userService = new UserService();
		userToAssembler = new UserToAssembler();
	}
	
	public void addUser(UserDetail personDetail) {
		BmiUser user = userToAssembler.createUser(personDetail);
		userService.addPerson(user);
	}

	
	public UserDetail getUserIfAuthenticated(String personId, String password) {
		BmiUser person = userService.getPerson(personId);
		if (person!= null && person.isCorrectPassword(password)) {
			return userToAssembler.creatUserDetailTo(person);
		} else {
			return null;
		}
	}
	
	public void addPerson(PersonDetail personDetail) {
		Person person = personToAssembler.createPerson(personDetail);
		getPersonService().addPerson(person);
	}

	public void addExamination(ExaminationDetail to, String personId) {
		Examination examination = examinationToAssembler.createExamination(to);
		getPersonService().addExamination(examination, personId);
	}

	public PersonDetail getPerson(String id) {
		Person person = getPersonService().getPerson(id);
		if (person == null) {
			throw new IllegalArgumentException("error.person.not.found");
		}
		return personToAssembler.createPersonDetailTo(person);
	}

	public double getAverageBmi()  {
		return getPersonService().getAverageBmi();
	}

	public List<PersonOverview> getPersons()  {
		List<Person> persons = getPersonService().getPersons();
		List<PersonOverview> personOverviewList = personToAssembler.createPersonOverviewTos(persons);
		return personOverviewList;
	}

	public void deletePerson(String id){
		getPersonService().deletePerson(id);
	}
	
	protected PersonService getPersonService() {
		return personService;
	}

	protected void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public String getMessage(String id) {
		return getPersonService().getMessage(id);
	}
}
