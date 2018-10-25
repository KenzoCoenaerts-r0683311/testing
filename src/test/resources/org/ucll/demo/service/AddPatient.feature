Feature: Add patient

  In order to monitor a	person
  As a caretaker
  I	can	register a new patient

  Scenario Outline: successfully adding a patient
    Given a patient with the social security number: "<number>", birth date: "<date>" and gender: "<gender>" is giving
    And length: "<length>", weight: "<weight>" and "<date>"

    When i try to add the patient
    And  I ask for information about the patient using his social security number "<number>"

    Examples:
      | number | date       | gender | length | weight |
      | 1      | 2010-08-02 | m      | 200    | 20000     |
      | 2      | 2010-08-02 | m      | 300   | 20000     |
      | 3      | 2010-08-02 | m      | 250   | 20000    |
      | 4      | 2010-08-02 | m      | 200   | 20000     |
      | 5      | 2010-08-02 | m      | 175   | 20000   |
      | 6      | 2010-08-02 | m      | 68    | 20000    |

  Scenario Outline: An error is thrown When no or wrong data is giving
    Given a patient with the social security number: "<number>", birth date: "<date>" and gender: "<gender>" is giving
    And length: "<length>", weight: "<weight>" and "<date>"
    When i try to add the patient
    Then an error is giving

    Examples:
      | number | date       | gender | length | weight  |
      | 1      | 2020-08-05 | f      | 300    | 20000   |
      | 2      | 1995-05-12 | f      | 25     | 20000   |
      | 3      | 2001-07-12 | m      | 350    | 20000   |
      | 4      | 1980-10-12 | f      | 100    | 150     |
      | 5      | 2012-07-05 | m      | 250    | 705000  |



