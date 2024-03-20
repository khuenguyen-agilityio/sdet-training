@UploadAttachment
Feature: User upload attachment

  Background: User login to Trello, choose the testing board and click on testing card
    Given The user is on Trello login page
    And The user input information with specify email "khue.nguyen@asnet.com.vn" and password "Hakhue98"
    And The user choose the board with name "New Test Board"
    And The user click on the card "New Test Card 001" on the "TODO" column
    And The user click on the Attachment button on the right sidebar

  @201 @delete_attachment
  Scenario: User upload attachment successfully
    When The user upload file with path "cat.jpg"
    Then Verify the user is able to see the file has been uploaded

  @202
  Scenario: User upload attachment successfully in case user input large file
    When The user upload file with path "11MB.bin"
    Then Verify the user is able to see "alert" toast with message "File size exceeds 10MB limit"