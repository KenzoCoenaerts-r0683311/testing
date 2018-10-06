Feature: Show patient details

  In order to check the physical condition of a patient
  As a caretaker
  I want to consult his/her personal details

  Scenario: the personal details of a registered patient are given
    Given a patient with the social security number 93051822361, gender male and birthdate 1993-05-18
    And on 2000-04-10 the patient had a length of 180 cm and a weight of 75000 gr
    And the patient is registered
    When I ask for the details of the patient using his social security number
    Then the personal details social security number, gender and birthdate are given
    And the examination details length, weight and last examination date are given
    And the calculated bmi 23.15 is given

  Scenario: the physical data of the most recent examination are given
    Given a patient with the social security number "93051822361"
    And on "2000-04-17" the patient had a length of 180 cm and a weight of 80000 gr
    And the patient is registered
    And on "2000-04-10" the patient had a length of 180 cm and a weight of 75000 gr but these data were added later
    When I ask for the details of the patient using his social security number
    Then the length 180, weight 80000, and date of the examination "2000-04-17â€œ are given
    And the calculated bmi 24.69 is based on these data

  Scenario: an error message is given if the patient cannot be found
    Given a patient that is not registered
    When I ask for the details of the patient using his social security number
    Then an error message is given
    And no details are given

  Scenario Outline: the bmi is rounded to 2 digits
    Given a patient that is registered with a length <length> cm and weight <weight> gr
    When I ask for the details of the patient
    Then the bmi <bmi> is given rounded to two digits

    Examples:
      |length  |weight	|bmi	|
      |160	   |65000	|25.39	|
      |160	   |65001	|25.39	|
      |160	   |65009	|25.39	|
      |180	   |75000	|23.15	|
      |180	   |75009	|23.15	|


