@ManageChecklist
Feature: User manage check list task in card

  Background: User login to Trello and go to the testing board
    Given The user is on Trello login page
    And The user input information with specify email "khue.nguyen@asnet.com.vn" and password "Hakhue98"
    And The user choose the board with name "New Test Board"
    And The user click on the card "New Test Card 001" on the list
    And The user click on checklist button on the right sidebar
    And The user create new checklist with title "Test Checklist"

  @101 @delete_checklist
  Scenario: User create check list items successfully
    When The user create checklist item
      | Checklist test item 001 |
      | Checklist test item 002 |
      | Checklist test item 003 |
      | Checklist test item 004 |
    Then Verify user is able to see the checklist item has been created