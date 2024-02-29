@Markie @Login
Feature: User login to Markie application

  @MK-001
  Scenario: User can login to Markie application successfully
    Given Login page is opened
    When Input information with specify email "khuenguyen2611@gmail.com" and password "P@ssword1"
    Then Verify user is able to see products page


  @MK-002
  Scenario: User login to Markie application unsuccessfully in case user enter empty email and password
    Given Login page is opened
    When Input information with specify email "" and password ""
    Then Verify user is able to see error message "This field must not be empty" on the page