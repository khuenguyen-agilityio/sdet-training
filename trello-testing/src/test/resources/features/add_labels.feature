@AddLabel
Feature: User add labels to the card

  Background: User login to Trello and go to the testing board
    Given The user is on Trello login page
    And The user input information with specify email "khue.nguyen@asnet.com.vn" and password "Hakhue98"
    And The user choose the board with name "New Test Board"
    And The user click on the card "New Test Card 001" on the list
    And The user click on label button on the right sidebar
    And The user click on button with title "Create a new label"

  @001 @delete_test_label
  Scenario: User add label to the card successfully
    When The user create new label with "Test label" title
    Then Verify user is able to see the card has label with given title

  @002
  Scenario: User add label to the card unsuccessfully in case user submit empty label and remove color
    When The user click on remove color button of a label
    Then Verify the user is not able to click "Create" button