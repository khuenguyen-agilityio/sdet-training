@Markie @SearchProduct
Feature: User search for product

  Background: User login to the site and go to add product page
    Given The user is on login page
    And The user input information with specify email "khuenguyen2611@gmail.com" and password "P@ssword1"

  @201 @202 @203
  Scenario Outline: User search for product with Category <category> and Keyword <keyword> successfully
    When The user select category <category> in Search with Category form control
    And The user input search keyword <keyword> in Search with form control
    And The user click on Search for product button on product page
    Then Verify search products have <category> category and name contains keyword <keyword>

    Examples:
      | category | keyword  |
      | "Dairy"  | "cheese" |
      | "Dairy"  | ""       |
      | ""       | "cheese" |

  @204
  Scenario: Display no product found when no product has been founded
    When The user select category "Fruit" in Search with Category form control
    And The user input search keyword "cheese" in Search with form control
    And The user click on Search for product button on product page
    Then Verify user can see no product found