package org.ucll.demo.service;

import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;
import org.junit.AfterClass;
import org.ucll.demo.domain.Gender;
import org.ucll.demo.service.api.java.to.PersonDetail;
import cucumber.api.java.After;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShowPatientDetailsSteps {
    private String socialSecurityNumber;
    private Gender gender = Gender.MALE;
    private Date birthDate;
    private PersonDetail patient;
    private PersonService service;

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-mm-dd");

    @After
    public void teardown() {
        //TODO replace with DBUnit, ...
        service.deletePerson(this.socialSecurityNumber);
    }

    @Given("^a patient with the social security number \"([^\"]*)\", gender \"([^\"]*)\" and birthdate \"([^\"]*)\"$")
    public void a_patient_with_the_social_security_number_gender_male_and_bitrhdate(String socialSecurityNumber, String gender, @Format("yyyy-mm-dd") Date birthDate) throws Throwable {
        this.socialSecurityNumber = socialSecurityNumber;
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.birthDate = birthDate;
        patient = new PersonDetail(this.socialSecurityNumber, this.gender, this.birthDate);
    }

    @Given("^on \"([^\"]*)\" the patient had a length of (\\d+) cm and a weight of (\\d+) gr$")
    public void on_the_patient_had_a_length_of_cm_and_a_weight_of_gr(String arg1, int arg2, int arg3) throws Throwable{
        //write code here that turns the phrase above into concrete actions
    }

    @Given("^the patient is registered$")
    public void the_patient_is_registerd() throws Throwable {
        //write code here that turns the phrase above into concrete actions
    }

    @When("^I ask for the details of the patient using his social security number$")
    public void i_ask_for_the_details_of_the_patient_using_his_social_security_number() throws Throwable {
        //write code here that turns the phrase above into concrete actions
    }

    @Then("^the personal details social security number, gender and bithdate are given$")
    public void the_personal_details_social_security_number_gender_and_birthdate_are_given() throws Throwable {
        //write code here that turns the phrase above into concrete actions
    }

    @Then("^the caculated bmi ((?:\\d|\\.)+) is given$")
    public void the_calcuated_bmi_is_given(double bmi) throws Throwable {
        assertEquals(bmi, detailsRetrieved.getBMI(), 0.0);
    }
}
