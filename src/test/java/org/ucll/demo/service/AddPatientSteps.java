package org.ucll.demo.service;

import cucumber.api.Format;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.ucll.demo.domain.Gender;
import org.ucll.demo.service.api.java.PersonServiceJavaApi;
import org.ucll.demo.service.api.java.to.ExaminationDetail;
import org.ucll.demo.service.api.java.to.PersonDetail;

import java.util.Date;

public class AddPatientSteps {
    private PersonDetail patient;
    private PersonDetail p2;
    private PersonServiceJavaApi api = new PersonServiceJavaApi();

    private boolean error = false;

    @After
    public void teardown(){ }

    @Given("^a patient with the social security number: \"([^\"]*)\", birth date: \"([^\"]*)\" and gender: \"([^\"]*)\" is giving$")
    public void a_patient_with_the_social_security_number_birth_date_and_gender_is_giving(String number, @Format("yyyy-MM-dd") Date birthDate, String gender) throws Throwable {
        patient = new PersonDetail(number, Gender.MALE, birthDate);
    }

    @Given("^length: \"([^\"]*)\", weight: \"([^\"]*)\" and \"([^\"]*)\"$")
    public void length_weight_and(String length, String weight, @Format("yyyy-MM-dd") Date birthDate) throws Throwable {
        try {
            ExaminationDetail examination = new ExaminationDetail(Integer.parseInt(length), Integer.parseInt(weight), birthDate);
            patient.setExaminationDetail(examination);
        } catch(Exception e){
            error = true;
        }

    }

    @When("^i try to add the patient$")
    public void i_try_to_add_the_patient() throws Throwable {
        try {
            api.addPerson(patient);
        } catch( Exception e ) {
            error = true;
        }
    }

    @Then("^an error is giving$")
    public void an_error_message_is_giving() throws Throwable {
        Assert.assertTrue(error);
    }

    @When("^i ask for the patient using his social security number: \"([^\"]*)\"$")
    public void i_ask_for_the_patient_using_his_social_security_number(String number) throws Throwable {
       p2 = api.getPerson(number);
    }

    @Then("^the number, date, length and weight are giving of the that patient$")
    public void the_number_date_length_and_weight_are_giving_of_the_that_patient() throws Throwable {
        Assert.assertEquals(patient.getSocialSecurityNumber(), p2.getSocialSecurityNumber());
        Assert.assertEquals(patient.getBirthdate(), p2.getBirthdate());
        Assert.assertEquals(patient.getExaminationDetail().getLength(), p2.getExaminationDetail().getLength());
        Assert.assertEquals(patient.getExaminationDetail().getWeight(), p2.getExaminationDetail().getWeight());
    }
}
