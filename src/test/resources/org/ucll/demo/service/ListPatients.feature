Feature: show patients

  Scenario: a list with the social security numbers of all patients is given
    Given a patient with a social security number "93051822361"
    And a patient with a social security number "870811220062"
    And both patients are registered
    When I ask to see a list of all my patients
    Then a patient with the social security number "93051822361" is given
    And a patient with the social security number "870811220062" is given

  Scenario: a list with the social security numbers of all patients is given after a patient is removed
    Given a patient with a social security number "93051822361"
    And a patient with a social security number "870811220062"
    And a patient with a social security number "570811220062"
    When patinet with social security number "570811220062" gets removed
    And  I ask to see a list of all my patients
    Then a patient with the social security number "93051822361" is given
    And a patient with the social security number "870811220062" is given
