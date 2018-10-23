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

    boolean error = false;

    @After
    public void teardown(){ }

    @Given("^a patient with the social security number: \"([^\"]*)\", birth date: \"([^\"]*)\" and gender: \"([^\"]*)\" is giving$")
    public void a_patient_with_the_social_security_number_birth_date_and_gender_is_giving(String number, @Format("yyyy-MM-dd") Date birthDate, String gender) throws Throwable {
        patient = new PersonDetail(number, Gender.MALE, birthDate);
    }

    @Given("^length: \"([^\"]*)\", weight: \"([^\"]*)\" and \"([^\"]*)\"$")
    public void length_weight_and(String length, String weight, @Format("yyyy-MM-dd") Date birthDate) throws Throwable {
        ExaminationDetail examination = new ExaminationDetail(Integer.parseInt(length), Integer.parseInt(weight), birthDate);
        patient.setExaminationDetail(examination);

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


    @When("^I ask for information about the patient using his social security number \"([^\"]*)\"$")
    public void i_ask_for_information_about_the_patient_using_his_social_security_number(String number) throws Throwable {
        p2 = api.getPerson(number);
    }
}
