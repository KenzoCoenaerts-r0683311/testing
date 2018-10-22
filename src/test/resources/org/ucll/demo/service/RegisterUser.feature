Feature: Register User
  As a user
  I	want to	register
  so that I’ll be able to buy products

  Scenario:
    Given a user with userid "1", first name: "test", last name: "rest", e-mail: "test.rest@gmail.com" and password "t"
    When I ask for the info about the user using his userid
    Then I get the first name "test", last name "rest" and e-mail "test.rest@gmail.com"
