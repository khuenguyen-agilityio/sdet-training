@Markie @AddProduct
Feature: User add new product

  Background: User login to the site and go to add product page
    Given The user is on login page
    And The user input information with specify email "khuenguyen2611@gmail.com" and password "P@ssword1"
    And The user click on button add product in the top right corner

  @101 @delete_new_test_product
  Scenario: User add new product successfully
    When The user fill product form with data
      | Name                 | Category | Quantity | Brand     | Price |
      | New Product Test 101 | Fruit    | 10       | New Brand | 1.99  |
    And The user click on save product button on product page
    Then Verify display success toast message "Add product successfully"
    And Verify new product has been created
      | Name                 | Category | Quantity | Brand     | Price |
      | New Product Test 101 | Fruit    | 10       | New Brand | 1.99  |

  @102
  Scenario: User add new product unsuccessfully in case user enter empty information
    When The user click on save product button on product page
    Then Verify user can see error message on input field
      | Field Name                   | Field Category               | Field Quantity                       | Field Brand                  | Field Price                          |
      | This field must not be empty | This field must not be empty | This field must be greater than zero | This field must not be empty | This field must be greater than zero |

  @103
  Scenario: User add new product unsuccessfully in case user enter product name has not enough length
    When The user fill product form with data
      | Name | Category | Quantity | Brand     | Price |
      | New  | Fruit    | 10       | New Brand | 1.99  |
    When The user click on save product button on product page
    Then Verify user can see error message on input field
      | Field Name                                  |
      | This field must have more than 8 characters |

  @104
  Scenario: User add new product unsuccessfully in case user enter product name has not enough length
    When The user fill product form with data
      | Name             | Category | Quantity | Brand | Price |
      | New Test Product | Fruit    | 10       | New   | 1.99  |
    When The user click on save product button on product page
    Then Verify user can see error message on input field
      | Field Brand                                 |
      | This field must have more than 6 characters |
