@Markie @AddProduct
Feature: User add new product

  Background: User login to the site and go to add product page
    Given Login page is opened
    And Input information with specify email "khuenguyen2611@gmail.com" and password "P@ssword1"
    And Click on header action button

  @MK-101
  Scenario: User add new product successfully
    When Fill product form with data
      | Name             | Category | Quantity | Brand     | Price |
      | New Test Product | Fruit    | 10       | New Brand | 1.99  |
    And Click on header action button
    Then Verify display success toast message "Add product successfully"
    And First product name of the list is "New Test Product"

  @MK-102
  Scenario: User add new product unsuccessfully in case user enter empty information
    When Click on header action button
    Then Verify display product name error message "This field must not be empty"
    And Verify display product category error message "This field must not be empty"
    And Verify display product quantity error message "This field must be greater than zero"
    And Verify display product brand error message "This field must not be empty"
    And Verify display product price error message "This field must be greater than zero"

  @MK-103
  Scenario: User add new product unsuccessfully in case user enter product name has not enough length
    When Fill product form with data
      | Name | Category | Quantity | Brand     | Price |
      | New  | Fruit    | 10       | New Brand | 1.99  |
    When Click on header action button
    Then Verify display product name error message "This field must have more than 8 characters"
