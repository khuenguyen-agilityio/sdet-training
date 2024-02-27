@Cura @target
Feature: Create new appointment

  Background: User login to the Cura site
    Given Cura Login Page is opened
    And Type "John Doe" and "ThisIsNotAPassword" to login

  Scenario: Create new appointment successfully
    When Select "Seoul CURA Healthcare Center" in Facility
    And Apply for hospital readmission
    And Pick visit date "20-Aug-2024"
    And Write comment "This is a comment"
    And Click submit appointment button
    Then verify appointment information