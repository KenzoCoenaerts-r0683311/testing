package org.ucll.demo.service;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterUserSteps {
    @Given("^a user with userid \"([^\"]*)\", first name: \"([^\"]*)\", last name: \"([^\"]*)\", e-mail: \"([^\"]*)\" and password \"([^\"]*)\"$")public void a_user_with_userid_first_name_last_name_e_mail_and_password(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    @When("^I ask for the info about the user using his userid$")
    public void i_ask_for_the_info_about_the_user_using_his_userid() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I get the first name \"([^\"]*)\", last name \"([^\"]*)\" and e-mail \"([^\"]*)\"$")
    public void i_get_the_first_name_last_name_and_e_mail(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
