@UploadAttachment
Feature: User manage check list task in card

  Background: User upload attachment
    Given The user is on Trello login page
    And The user input information with specify email "khue.nguyen@asnet.com.vn" and password "Hakhue98"
    And The user choose the board with name "New Test Board"
    And The user click on the card "New Test Card 001" on the list
    And The user click on the Attachment button on the right sidebar

  @201 @delete_attachment
  Scenario: User upload attachment successfully
    When The user upload file with path "\Users\Khue Nguyen\Desktop\test\cat_image.jpg"
    Then Verify the user is able to see the file has been uploaded