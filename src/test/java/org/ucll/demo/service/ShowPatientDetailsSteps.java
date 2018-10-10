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

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class ShowPatientDetailsSteps {
    private  String socialSecurityNumber;
    private Gender gender = Gender.MALE;
    private Date birthDate;
    private PersonDetail patient;
    private ExaminationDetail examinationDetail;
    private PersonServiceJavaApi personApi = new PersonServiceJavaApi();
    private int length;
    private int weight;

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-mm-dd");


    @Given("^a patient with the social security number (\\d+), gender male and birthdate (\\d+)-(\\d+)-(\\d+)$")
    public void a_patient_with_the_social_security_number_gender_male_and_birthdate(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        this.socialSecurityNumber = Integer.toString(arg1);
        this.gender = Gender.MALE;
        this.birthDate = DATE_FORMATTER.parse(arg2+"-"+arg3+"-"+arg4);
        patient = new PersonDetail(this.socialSecurityNumber, this.gender, this.birthDate);
    }

    @Given("^on (\\d+)-(\\d+)-(\\d+) the patient had a length of (\\d+) cm and a weight of (\\d+) gr$")
    public void on_the_patient_had_a_length_of_cm_and_a_weight_of_gr(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        this.birthDate = DATE_FORMATTER.parse(arg1+"-"+arg2+"-"+arg3);
        this.length = arg4;
        this.weight = arg5;
        examinationDetail = new ExaminationDetail(this.length, this.weight);
    }

    @Given("^the patient is registered$")
    public void the_patient_is_registered() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask for the details of the patient using his social security number$")
    public void i_ask_for_the_details_of_the_patient_using_his_social_security_number() throws Throwable {
        try {
            personApi.getPerson(this.socialSecurityNumber);
        } catch (IllegalArgumentException e){

        }
    }

    @Then("^the personal details social security number, gender and birthdate are given$")
    public void the_personal_details_social_security_number_gender_and_birthdate_are_given() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the examination details length, weight and last examination date are given$")
    public void the_examination_details_length_weight_and_last_examination_date_are_given() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the calculated bmi (\\d+)\\.(\\d+) is given$")
    public void the_calculated_bmi_is_given(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^a patient with the social security number \"([^\"]*)\"$")
    public void a_patient_with_the_social_security_number(String arg1) throws Throwable {
        this.socialSecurityNumber = arg1;
        this.gender = Gender.MALE;
        this.birthDate = DATE_FORMATTER.parse("2000-04-02");
        patient = new PersonDetail(this.socialSecurityNumber, this.gender, this.birthDate);
    }

    @Given("^on \"([^\"]*)\" the patient had a length of (\\d+) cm and a weight of (\\d+) gr$")
    public void on_the_patient_had_a_length_of_cm_and_a_weight_of_gr(@Format("yyyy-mm-dd") Date arg1, int arg2, int arg3) throws Throwable {
        this.birthDate = arg1;
        this.length = arg2;
        this.weight = arg3;
        examinationDetail = new ExaminationDetail(this.length, this.weight);
    }

    @Given("^on \"([^\"]*)\" the patient had a length of (\\d+) cm and a weight of (\\d+) gr but these data were added later$")
    public void on_the_patient_had_a_length_of_cm_and_a_weight_of_gr_but_these_data_were_added_later(String arg1, int arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the length (\\d+), weight (\\d+), and date of the examination \"(\\d+)-(\\d+)-(\\d+)â€œ are given$")
    public void the_length_weight_and_date_of_the_examination_â€œ_are_given(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the calculated bmi (\\d+)\\.(\\d+) is based on these data$")
    public void the_calculated_bmi_is_based_on_these_data(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^a patient that is not registered$")
    public void a_patient_that_is_not_registered() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^an error message is given$")
    public void an_error_message_is_given() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^no details are given$")
    public void no_details_are_given() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^a patient that is registered with a length (\\d+) cm and weight (\\d+) gr$")
    public void a_patient_that_is_registered_with_a_length_cm_and_weight_gr(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask for the details of the patient$")
    public void i_ask_for_the_details_of_the_patient() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the bmi (\\d+)\\.(\\d+) is given rounded to two digits$")
    public void the_bmi_is_given_rounded_to_two_digits(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();

    }
}