@MovingCards
Feature: User move card between columns

  Background: User login to Trello and choose the testing board
    Given The user is on Trello login page
    And The user input information with specify email "khue.nguyen@asnet.com.vn" and password "Hakhue98"
    And The user choose the board with name "New Test Board"

  @301 @move_back_card
  Scenario: User can move card between columns successfully
    When The user move the card "New Test Card 001" from "TODO" column to "DONE" column
    Then Verify the user is able to see the card in the column moved

  @302
  Scenario: User move card between columns unsuccessfully in case user doesn't move card outside the column
    When The user move the card "New Test Card 001" from "TODO" column to "TODO" column
    Then Verify the user is able to see the card has not been moved