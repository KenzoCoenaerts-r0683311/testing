package org.ucll.demo.service;

import cucumber.api.Format;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.ucll.demo.domain.Gender;
import org.ucll.demo.service.api.java.PersonServiceJavaApi;
import org.ucll.demo.service.api.java.to.ExaminationDetail;
import org.ucll.demo.service.api.java.to.PersonDetail;

import java.util.Date;

public class AddPatientSteps {
    private PersonDetail patient;
    private PersonDetail p2;
    private PersonServiceJavaApi api = new PersonServiceJavaApi();
    private Gender gender;

    @Given("^a patient with the social security number: \"([^\"]*)\", birth date: \"([^\"]*)\" and gender: \"([^\"]*)\" is giving$")
    public void a_patient_with_the_social_security_number_birth_date_and_gender_is_giving(String number, @Format("yyyy-MM-dd") Date birthDate, String gender) throws Throwable {
        patient = new PersonDetail(number, Gender.valueOf(gender.toUpperCase()), birthDate);
    }

    @Given("^length: \"([^\"]*)\", weight: \"([^\"]*)\"$")
    public void length_weight(String length, String weight) throws Throwable {
        ExaminationDetail examination = new ExaminationDetail(Integer.parseInt(length), Integer.parseInt(weight));
        patient.setExaminationDetail(examination);
    }

    @When("^I ask for information about the patient using his social security number \"([^\"]*)\"$")
    public void i_ask_for_information_about_the_patient_using_his_social_security_number(String number) throws Throwable {
        p2 = api.getPerson(number);
    }

    @Then("^I get the birth date: \"([^\"]*)\" of the patient$")
    public void i_get_the_birth_date_of_the_patient(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
