Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation successful with correct username and password
    Given new user is selected
    When new username "heikki" and new password "huihai" are given
    Then new user is created and welcome page is shown

  Scenario: creation fails with too short username and valid passord
    Given new user is selected
    When too short username "we" and valid password "huihai" are given
    Then user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given new user is selected
    When valid username "heikki" and too short password "xy" are given
    Then user is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails with correct username and password consisting of letters
    Given new user is selected
    When ...
    Then user is not created and error "password can not contain only letters" is reported

  Scenario: creation fails with already taken username and valid pasword
    Given new user is selected
    When ...
    Then user is not created and error "username is already taken" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given new user is selected
    When ...
    Then user is not created and error "password and password confirmation do not match" is reported
