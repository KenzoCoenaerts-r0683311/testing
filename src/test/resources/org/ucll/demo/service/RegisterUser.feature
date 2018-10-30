Feature: Register User
  As a user
  I	want to	register
  so that I’ll be able to buy products

  Scenario Outline: successfully register
    Given a user with userid "<id>", first name: "<firstName>", last name: "<lastName>", e-mail: "<e-mail>" and password "<password>"
    And the user is registerd
    When I ask for the info about the user using his userid
    Then I get the first name "test", last name "rest" and e-mail "test.rest@gmail.com"

    Examples:

    | id | firstName | lastName | e-mail              | password |
    | 1  | test      | wow      | test.wow@gmail.com  | t        |
    | 2  | test      | wow      | test.wow@gmail.com  | t        |
    | 3  | test      | wow      | test.wow@gmail.com  | t        |
    | 4  | test      | wow      | test.wow@gmail.com  | t        |
    | 5  | test      | wow      | test.wow@gmail.com  | t        |
    | 6  | test      | wow      | test.wow@gmail.com  | t        |

  Scenario Outline:  An error is thrown When no or wrong data is giving
    Given a user with userid "<id>", first name: "<firstName>", last name: "<lastName>", e-mail: "<e-mail>" and password "<password>"
    And the user is registerd
    Then an error is thrown

    Examples:
      | id | firstName | lastName | e-mail              | password |
      | -1  | test     | wow      | test.wow@gmail.com  | t        |
      | 2  |  ""       | wow      | test.wow@gmail.com  | t        |
      | 3  | test      | ""       | test.wow@gmail.com  | t        |
      | 4  | test      | wow      | testl.com           | t        |
      | 5  | test      | wow      | test.wow@gmail.com  | ""       |
      | 6  | test      | wow      | ""                  | t        |



