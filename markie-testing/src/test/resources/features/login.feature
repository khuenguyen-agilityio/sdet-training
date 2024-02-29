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

  @MK-003
  Scenario: User login to Markie application unsuccessfully in case user enter invalid email and invalid password
    Given Login page is opened
    When Input information with specify email "wrongemail@gmail.com" and password "Not@pwd1"
    Then Verify user is able to see toast message "Login failed. Please check your email and password"

  @MK-004
  Scenario: User login to Markie application unsuccessfully in case user enter wrong email format and valid password
    Given Login page is opened
    When Input information with specify email "wrongemailformat" and password "P@ssword1"
    Then Verify user is able to see email error message "This field must be an email address"