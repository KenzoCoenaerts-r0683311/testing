package org.ucll.demo.service;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.ucll.demo.domain.BmiUser;
import org.ucll.demo.service.api.java.UserServiceJavaApi;
import org.ucll.demo.service.api.java.to.UserDetail;

import java.util.ArrayList;
import java.util.List;


public class RegisterUserSteps {
    private UserServiceJavaApi userApi = new UserServiceJavaApi();
    private boolean error = false;
    private UserDetail user;
    private List<UserDetail> userDetails = new ArrayList<>();

    @Given("^a user with userid \"([^\"]*)\", first name: \"([^\"]*)\", last name: \"([^\"]*)\", e-mail: \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void a_user_with_userid_first_name_last_name_e_mail_and_password(String id, String firstName, String lastName, String email, String password) throws Throwable {
        //user = new BmiUser(id, firstName, lastName, email, password);
    }

    @When("^the user is registerd$")
    public void the_user_is_registerd() throws Throwable {
        try {
            userApi.addPerson(user);
        } catch(Exception e){
            error = true;
        }
    }

    @When("^I ask for the info about the user using his userid$")
    public void i_ask_for_the_info_about_the_user_using_his_userid() throws Throwable {
        //userDetails = userApi.getUsers();
    }

    @Then("^I get the first name \"([^\"]*)\", last name \"([^\"]*)\"\"([^\"]*)\"test\\.wow@gmail\\.com\"$")
    public void i_get_the_first_name_last_name_test_wow_gmail_com(String firstName, String lastName, String email) throws Throwable {
        /*Assert.assertEquals(firstName, userDetails[0).getFirstName());
        Assert.assertEquals(lastName, userDetails[0).getLastName());
        Assert.assertEquals(email, userDetails[0).getEmail());*/
    }

    @Then("^an error is thrown$")
    public void an_error_is_thrown() throws Throwable {
        Assert.assertEquals(true, error);
    }

}
