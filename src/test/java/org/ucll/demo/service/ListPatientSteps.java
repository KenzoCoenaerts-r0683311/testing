package org.ucll.demo.service;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.ucll.demo.domain.Gender;
import org.ucll.demo.service.api.java.PersonServiceJavaApi;
import org.ucll.demo.service.api.java.to.ExaminationDetail;
import org.ucll.demo.service.api.java.to.PersonDetail;
import org.ucll.demo.service.api.java.to.PersonOverview;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListPatientSteps {
    private PersonServiceJavaApi personApi = new PersonServiceJavaApi();

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    private int counter = 0;

    private List<PersonOverview> overview;
    private List<PersonDetail> personDetails = new ArrayList<>();

    @After
    public void teardown() {
        personApi = new PersonServiceJavaApi();
    }

    @Given("^a patient with a social security number \"([^\"]*)\"$")
    public void a_patient_with_the_social_security_number(String socialSecurityNumber) throws Throwable {
        PersonDetail patient = new PersonDetail(socialSecurityNumber, Gender.MALE, DATE_FORMATTER.parse("1993-05-18"));
        ExaminationDetail examinationDetail = new ExaminationDetail(180, 50000, DATE_FORMATTER.parse("1993-05-18"));
        patient.setExaminationDetail(examinationDetail);
        personDetails.add(patient);
    }

    @Given("^both patients are registered$")
    public void both_patients_are_registered() throws Throwable {
        for(PersonDetail personDetail: personDetails)
            personApi.addPerson(personDetail);
    }

    @When("^I ask to see a list of all my patients$")
    public void i_ask_to_see_a_list_of_all_my_patients() throws Throwable {
        this.overview = personApi.getPersons();
    }

    @When("^patinet with social security number \"([^\"]*)\" gets removed$")
    public void patinet_with_social_security_number_gets_removed(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        personApi.deletePerson(arg1);
    }

    @Then("^a patient with the social security number \"([^\"]*)\" is given$")
    public void a_patient_with_the_social_security_number_is_given(String socialSecurityNumbers) throws Throwable {
        Assert.assertEquals(overview.get(counter).toString(), socialSecurityNumbers);
        counter++;
    }
}
