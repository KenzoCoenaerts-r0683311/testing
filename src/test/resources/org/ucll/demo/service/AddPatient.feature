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
      | 1      | 2010-08-02 | m      | 200    | 300    |
      | 2      | 2010-09-02 | f      | 300    | 30000  |
      | 3      | 2010-08-03 | m      | 250    | 25000  |
      | 4      | 2000-08-02 | trans  | 200    | 301    |
      | 5      | 2010-10-02 | m      | 175    | 20123  |
      | 6      | 1995-08-02 | f      | 68     | 500    |
      | 7      | 1995-08-02 | f      | 50     | 300    |
      | 7      | 1995-08-02 | f      | 300    | 700000 |

  Scenario Outline: An error is thrown When no or wrong data is giving
    Given a patient with the social security number: "<number>", birth date: "<date>" and gender: "<gender>" is giving
    And length: "<length>", weight: "<weight>" and "<date>"
    When i try to add the patient
    Then an error is giving

    Examples:
      | number | date       | gender | length | weight  |
      | -1     | 2020-08-05 | f      | 300    | 20000   |
      | 1      | 2020-08-05 | f      | 300    | 20000   |
      | 2      | 1995-05-12 | f      | 25     | 20000   |
      | 3      | 2001-07-12 | m      | 350    | 20000   |
      | 4      | 1980-10-12 | f      | 100    | 150     |
      | 5      | 2012-07-05 | m      | 250    | 705000  |
      | 6      | 1995-08-02 | f      | 49     | 300     |
      | 8      | 1995-08-02 | f      | 50     | 299     |
      | 10     | 1995-08-02 | f      | 50     | 301     |
      | 11     | 1995-08-02 | m      | 300    | 700001  |
      | 12     | 1995-08-02 | f      | 51     | 300     |
      | 13     | 1995-08-02 | f      | 301    | 700000  |
      | 10     | 1995-08-02 | f      | -5     | 301     |
      | 11     | 1995-08-02 | m      | -3     | 700001  |
      | 12     | 1995-08-02 | f      | 50     | -300    |
      | 13     | 1995-08-02 | f      | 300    | -700000 |
      | ""     | 2010-09-02 | m      | 200    | 300    |
      | 14     | ""         | f      | 250    | 30000  |
      | 15     | 2010-08-03 | m      | ""     | 30000  |
      | 16     | 2000-08-02 | trans  | 200    | ""    |




