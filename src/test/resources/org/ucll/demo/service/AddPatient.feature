Feature: Add patient

  In order to monitor a	person
  As a caretaker
  I	can	register a new patient

  Scenario Outline: successfully adding a patient
    Given a patient with the social security number: <number>, birth date: <date> and gender is giving <gender>
    And length: <length>, weight: <weight>
    When I ask for information about the patient using his social security number <number>
    Then I get the birth date: <date> of the patient

    Examples:
      |number  |date	    | gender | length | weight
      |1	   |2010-08-03	| M      | 50     | 300
      |2	   |1995-06-05	| F      | 300    | 305083
      |3	   |2010-08-03	| M      | 155    | 1050
      |4	   |1995-06-05	| F      | 202    | 700000
      |3	   |2010-08-03	| M      | 155    | 1050
      |4	   |1995-06-05	| F      | 202    | 700000



  Scenario Outline: A error message is giving when trying to add patient with no or incorrect data
    Given a patient with the social security number: <number>, birth date: <date>

    Examples:
      |number  |date	    | gender | length | weight
      |-5	   |2010-08-03	| M      | 50     | 300
      |1	   |2020-06-05	| F      | 100    | 500
      |2	   |2010-08-03	| M      | 20     | 1000
      |3	   |2010-06-05	| F      | 400    | 800
      |4	   |2010-08-03	| M      | 60     | 100
      |5	   |2010-06-05	| F      | 250    | 750000


