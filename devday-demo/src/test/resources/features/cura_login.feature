@regression @Cura
Feature: Cura Login

  @311
  Scenario: Verify user is able to login to the Cura Page
    Given Cura Login Page is opened
    When Type "John Doe" and "ThisIsNotAPassword" to login
    Then User can see Appointment Page
