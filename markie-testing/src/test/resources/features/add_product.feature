@Markie @AddProduct
Feature: User add new product

  Background: User login to the site and go to add product page
    Given Login page is opened
    And Input information with specify email "khuenguyen2611@gmail.com" and password "P@ssword1"
    And Click on header action button

  @MK-201
  Scenario: User add new product successfully
    When Fill product form with data
      | Name             | Category | Quantity | Brand     | Price |
      | New Test Product | Fruit    | 10       | New Brand | 1.99  |
    And Click on header action button
    Then Verify display success toast message "Add product successfully"
    And First product name of the list is "New Test Product"