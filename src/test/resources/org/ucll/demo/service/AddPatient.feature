Feature: Add patient

  In order to monitor a	person
  As a caretaker
  I	can	register a new patient

  Scenario Outline: successfully adding a patient
    Given a patient with the social security number: "<number>", birth date: "<date>" and gender: "<gender>" is giving
    And length: "<length>", weight: "<weight>"
    When I ask for information about the patient using his social security number "<number>"
    Then I get the birth date: "<date>" of the patient

    Examples:
     | number | date       | gender | length | weight |
     | 1      | 2010-08-02 | M      | 50    | 500     |
     | 2      | 2010-08-02 | M      | 300   | 850     |
     | 3      | 2010-08-02 | M      | 250   | 1638    |
     | 4      | 2010-08-02 | M      | 200   | 320     |
     | 5      | 2010-08-02 | M      | 175   | 85406   |
     | 6      | 2010-08-02 | M      | 68    | 2300    |

  Scenario Outline: An error is thrown When no or wrong data is giving
    Given a patient with the social security number: "<number>", birth date: "<date>" and gender: "<gender>" is giving
    And length: "<length>", weight: "<weight>"

    Examples:
      | number | date       | gender | length | weight  |
      | -5     | 2010-08-05 | M      | 150    | 500     |
      | 1      | 2020-08-05 | F      | 300    | 1000    |
      | 2      | 1995-05-12 | F      | 25     | 800     |
      | 3      | 2001-07-12 | M      | 350    | 2500    |
      | 4      | 1980-10-12 | F      | 100    | 150     |
      | 5      | 2012-07-05 | M      | 250    | 705000  |



