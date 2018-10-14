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

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.thoughtworks.selenium.SeleneseTestBase.assertNotEquals;
//import static org.junit.Assert.assertEquals;

public class ShowPatientDetailsSteps {
    private String socialSecurityNumber;
    private Gender gender;
    private Date birthDate;
    private PersonDetail patient;

    private Date date;
    private int length;
    private int weight;
    private ExaminationDetail examinationDetail;

    private PersonServiceJavaApi personApi = new PersonServiceJavaApi();

    private boolean error;
    private String message;

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    @After
    public void teardown() {
        if (!error)
            personApi.deletePerson(patient.getSocialSecurityNumber());

        message = null;
        error = false;
    }

    @Given("^a patient with the social security number \"([^\"]*)\", gender \"([^\"]*)\" and birthdate \"([^\"]*)\"$")
    public void a_patient_with_the_social_security_number_gender_and_birthdate(String socialSecurityNumber, String gender, @Format("yyyy-MM-dd") Date birthDate) throws Throwable {
        this.socialSecurityNumber = socialSecurityNumber;
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.birthDate = birthDate;
        patient = new PersonDetail(socialSecurityNumber, Gender.valueOf(gender.toUpperCase()), birthDate);
    }

    @Given("^a patient with the social security number \"([^\"]*)\"$")
    public void a_patient_with_the_social_security_number(String socialSecurityNumber) throws Throwable {
        this.socialSecurityNumber = socialSecurityNumber;
        this.gender = Gender.MALE;
        this.birthDate = DATE_FORMATTER.parse("1993-05-18");
        patient = new PersonDetail(this.socialSecurityNumber, this.gender, this.birthDate);
    }

    @Given("^a patient that is registered with a length (\\d+) cm and weight (\\d+) gr$")
    public void a_patient_that_is_registered_with_a_length_cm_and_weight_gr(int length, int weight) throws Throwable {
        patient = new PersonDetail("93051822361", Gender.MALE, DATE_FORMATTER.parse("1993-05-18"));
        date = DATE_FORMATTER.parse("2000-04-10");
        this.examinationDetail = new ExaminationDetail(length, weight, this.date);
        patient.setExaminationDetail(this.examinationDetail);
        personApi.addPerson(patient);
    }

    @Given("^a patient that is not registered$")
    public void a_patient_that_is_not_registered() throws Throwable {
        patient = new PersonDetail(this.socialSecurityNumber, this.gender, this.birthDate);
    }

    @Given("^on \"([^\"]*)\" the patient had a length of (\\d+) cm and a weight of (\\d+) gr$")
    public void on_the_patient_had_a_length_of_cm_and_a_weight_of_gr(@Format("yyyy-MM-dd") Date examinationDate, int length, int weight) throws Throwable {
        this.length = length;
        this.weight = weight;
        this.date = examinationDate;
        this.examinationDetail = new ExaminationDetail(this.length, this.weight, this.date);
        patient.setExaminationDetail(this.examinationDetail);
    }

    @Given("^on \"([^\"]*)\" the patient had a length of (\\d+) cm and a weight of (\\d+) gr but these data were added later$")
    public void on_the_patient_had_a_length_of_cm_and_a_weight_of_gr_but_these_data_were_added_later(@Format("yyyy-MM-dd") Date examinationDate, int length, int weight) throws Throwable {
        this.length = length;
        this.weight = weight;
        this.date = examinationDate;
        this.examinationDetail = new ExaminationDetail(this.length, this.weight, this.date);
        patient.setExaminationDetail(this.examinationDetail);
    }

    @Given("^the patient is registered$")
    public void the_patient_is_registered() throws Throwable {
        personApi.addPerson(patient);
    }

    @When("^I ask for the details of the patient using his social security number$")
    public void i_ask_for_the_details_of_the_patient_using_his_social_security_number() throws Throwable {
        try {
            patient = personApi.getPerson(patient.getSocialSecurityNumber());
        } catch (Exception e) {
            error = true;
            message = e.getMessage();
        }
    }

    @When("^I ask for the details of the patient$")
    public void i_ask_for_the_details_of_the_patient() throws Throwable {
        try {
            patient = personApi.getPerson(patient.getSocialSecurityNumber());
        } catch (Exception e) {
            error = true;
            message = e.getMessage();
        }
    }

    @Then("^the personal details social security number, gender and birthdate are given$")
    public void the_personal_details_social_security_number_gender_and_birthdate_are_given() throws Throwable {
        Assert.assertEquals(socialSecurityNumber, patient.getSocialSecurityNumber());
        Assert.assertEquals(gender, patient.getGender());
        Assert.assertEquals(birthDate, patient.getBirthdate());
    }

    @Then("^the examination details length, weight and last examination date are given$")
    public void the_examination_details_length_weight_and_last_examination_date_are_given() throws Throwable {
        examinationDetail = patient.getExaminationDetail();
        Assert.assertEquals(length, examinationDetail.getLength());
        Assert.assertEquals(weight, examinationDetail.getWeight());
        Assert.assertEquals(date, examinationDetail.getExaminationDate());
    }

    @Then("^the length (\\d+), weight (\\d+), and date of the examination \"([^\"]*)\" are given$")
    public void the_length_weight_and_date_of_the_examination_are_given(int length, int weight, @Format("yyyy-MM-dd") Date examinationDate) throws Throwable {
        examinationDetail = patient.getExaminationDetail();
        Assert.assertEquals(length, examinationDetail.getLength());
        Assert.assertEquals(weight, examinationDetail.getWeight());
        Assert.assertEquals(examinationDate, examinationDetail.getExaminationDate());
    }

    @Then("^the calculated bmi \"([^\"]*)\" is given$")
    public void the_calculated_bmi_is_given(double bmi) throws Throwable {
        Assert.assertEquals(bmi, patient.getBmi(), 0.0);
    }

    @Then("^the calculated bmi \"([^\"]*)\" is based on these data$")
    public void the_calculated_bmi_is_based_on_these_data(double bmi) throws Throwable {
        Assert.assertEquals(bmi, patient.getBmi(), 0.0);
    }

    @Then("^an error message is given$")
    public void an_error_message_is_given() throws Throwable {
        assertNotEquals(null, message);
    }

    @Then("^no details are given$")
    public void no_details_are_given() throws Throwable {
        Assert.assertEquals(error, true);
    }

    @Then("^the bmi (\\d+)\\.(\\d+) is given rounded to two digits$")
    public void the_bmi_is_given_rounded_to_two_digits(int arg1, int arg2) throws Throwable {
        Assert.assertEquals(Double.parseDouble("" + arg1 + "." + arg2 + ""), patient.getBmi(), 0.0);
    }
}