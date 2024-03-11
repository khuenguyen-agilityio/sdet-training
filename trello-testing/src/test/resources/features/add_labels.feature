@Trello @AddLabel
Feature: User add labels to the card

  Background: User login to Trello and go to the testing board
    Given The user is on Trello login page
    And The user input information with specify email "khue.nguyen@asnet.com.vn" and password "Hakhue98"
    And The user choose the board with name "New Test Board"

  @001 @delete_test_label
  Scenario: User add label to the card successfully
    And User click on the card "New Test Card 001" on the list
    When The user create new label with "Test label" title
    Then Verify user is able to see the card has label with given title