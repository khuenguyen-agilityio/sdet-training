@Markie @SearchProduct
Feature: User search for product

  Background: User login to the site and go to add product page
    Given Login page is opened
    And Input information with specify email "khuenguyen2611@gmail.com" and password "P@ssword1"

  @MK-201 @MK-202 @MK-203
  Scenario Outline: User search for product with Category and Name successfully
    When Select category <category> in Search with Category form control
    And Input search keyword <keyword> in Search with form control
    And Click on Search button
    Then Verify search products have <category> category and name contains keyword <keyword>

    Examples:
      | category | keyword  |
      | "Dairy"  | "cheese" |
      | "Dairy"  | ""       |
      | ""       | "cheese" |