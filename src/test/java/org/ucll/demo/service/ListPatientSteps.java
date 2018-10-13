package org.ucll.demo.service;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Lu;
import org.junit.Assert;
import org.ucll.demo.domain.Gender;
import org.ucll.demo.service.api.java.PersonServiceJavaApi;
import org.ucll.demo.service.api.java.to.ExaminationDetail;
import org.ucll.demo.service.api.java.to.PersonDetail;
import org.ucll.demo.service.api.java.to.PersonOverview;
import sun.font.TrueTypeFont;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ListPatientSteps {
    private PersonServiceJavaApi personApi = new PersonServiceJavaApi();

    private PersonDetail patient;
    private ExaminationDetail examinationDetail;
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    private boolean error = false;
    private String socialSecurityNumber;
    private Gender gender;
    private Date birthDate;
    private int i = 0;

    private List<PersonOverview> overview;
    private List<PersonDetail> personDetails;

    @Given("^a patient with a social security number \"([^\"]*)\"$")
    public void a_patient_with_the_social_security_number(String arg1) throws Throwable {
        this.socialSecurityNumber = arg1;
        this.gender = Gender.MALE;
        this.birthDate = DATE_FORMATTER.parse("1993-05-18");
        this.examinationDetail = new ExaminationDetail(180,50000, DATE_FORMATTER.parse("1993-05-18"));
        patient = new PersonDetail(this.socialSecurityNumber, this.gender, this.birthDate);
        patient.setExaminationDetail(examinationDetail);
        personDetails.add(patient);
    }

    @Given("^both patients are registered$")
    public void both_patients_are_registered() throws Throwable {
        for(PersonDetail personDetail: personDetails) {
            personApi.addPerson(personDetail);
        }
    }

    @When("^I ask to see a list of all my patients$")
    public void i_ask_to_see_a_list_of_all_my_patients() throws Throwable {
        try {
            this.overview = personApi.getPersons();
        } catch(Exception e){
            error = true;
        }
    }

    @Then("^a patient with the social security number \"([^\"]*)\" is given$")
    public void a_patient_with_the_social_security_number_is_given(String socialSecurityNumbers) throws Throwable {
        Assert.assertEquals(overview.get(i).toString(), socialSecurityNumbers);
        i++;
    }
}
