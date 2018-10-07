package org.ucll.demo.service;

import cucumber.api.Format;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.ucll.demo.domain.Gender;

import org.ucll.demo.service.api.java.PersonServiceJavaApi;
import org.ucll.demo.service.api.java.to.ExaminationDetail;
import org.ucll.demo.service.api.java.to.PersonDetail;
import cucumber.api.java.After;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class ShowPatientDetailsSteps {
    private String socialSecurityNumber;
    private Gender gender = Gender.MALE;
    private Date birthDate;
    private PersonDetail patient;
    private PersonServiceJavaApi api = new PersonServiceJavaApi();

    @After
    public void teardown() {
        //TODO replace with DBUnit, ...
        //service.deletePerson(this.socialSecurityNumber);
    }

    @Given("^a patient with the social security number \"([^\"]*)\", gender \"([^\"]*)\" and birthdate \"([^\"]*)\"$")
    public void a_patient_with_the_social_security_number_gender_male_and_bitrhdate(String socialSecurityNumber, String gender, @Format("yyyy-mm-dd") Date birthDate) throws Throwable {
        this.socialSecurityNumber = socialSecurityNumber;
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.birthDate = birthDate;
        patient = new PersonDetail(this.socialSecurityNumber, this.gender, this.birthDate);
    }

    @Given("^on \"([^\"]*)\" the patient had a length of (\\d+) cm and a weight of (\\d+) gr$")
    public void on_the_patient_had_a_length_of_cm_and_a_weight_of_gr(@Format("yyyy-mm-dd") Date birthDate, int length, int weight) throws Throwable {
        //write code here that turns the phrase above into concrete actions
        //PersonDetail p = api.getPerson(socialSecurityNumber);
        //ExaminationDetail detail = p.getExaminationDetail();
        //assertEquals(detail.getLength(), length);
        //assertEquals(detail.getWeight(), weight);
        //throw new PendingException();
    }

    @Given("^the patient is registered$")
    public void the_patient_is_registerd() throws Throwable {
        //write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask for the details of the patient using his social security number$")
    public void i_ask_for_the_details_of_the_patient_using_his_social_security_number() throws Throwable {
        //write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^a patient that is not registered$")
    public void a_patient_that_is_not_registered() {
        api.getPerson("t");
    }

    @Then("^the personal details social security number, gender and bithdate are given$")
    public void the_personal_details_social_security_number_gender_and_birthdate_are_given() throws Throwable {
        //write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^a patient with the social security number \"([^\"]*)\"$")
    public void a_patient_with_the_social_security_number(String socialSecurityNumber) throws Throwable {
        patient = api.getPerson(socialSecurityNumber);
    }

    @Given("^on \"([^\"]*)\" the patient had a length of (\\d+) cm and a weight of (\\d+) gr but these data were added later$")
    public void on_the_patient_had_a_length_of_cm_and_a_weight_of_gr_but_these_data_were_added_later(@Format("yyyy-mm-dd") Date birthDate, int length, int weight) throws Throwable {
        ExaminationDetail detail = new ExaminationDetail(length, weight, birthDate);
        patient.setExaminationDetail(detail);
    }

    @Then("^the length 180, weight 80000, and date of the examination \"2000-04-17â€œ are given$")
    public void t() {

    }

    @Then("^the caculated bmi ((?:\\d|\\.)+) is given$")
    public void the_calcuated_bmi_is_given(double bmi) throws Throwable {
        assertEquals(bmi, patient.getBmi(), 0.0);
    }
}
