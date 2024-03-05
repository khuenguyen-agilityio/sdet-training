@Markie @AddProduct
Feature: User add new product

  Background: User login to the site and go to add product page
    Given Login page is opened
    And Input information with specify email "khuenguyen2611@gmail.com" and password "P@ssword1"
    And Click on button add product in the top right corner

  @101 @delete_new_test_product
  Scenario: User add new product successfully
    When Fill product form with data
      | Name                 | Category | Quantity | Brand     | Price |
      | New Product Test 101 | Fruit    | 10       | New Brand | 1.99  |
    And Click on save product button on product page
    Then Verify display success toast message "Add product successfully"
    And Verify new product has been created
      | Name                 | Category | Quantity | Brand     | Price |
      | New Product Test 101 | Fruit    | 10       | New Brand | 1.99  |

  @102
  Scenario: User add new product unsuccessfully in case user enter empty information
    When Click on save product button on product page
    Then Verify display product error message
      | Field Name                   | Field Category               | Field Quantity                       | Field Brand                  | Field Price                          |
      | This field must not be empty | This field must not be empty | This field must be greater than zero | This field must not be empty | This field must be greater than zero |

  @103
  Scenario: User add new product unsuccessfully in case user enter product name has not enough length
    When Fill product form with data
      | Name | Category | Quantity | Brand     | Price |
      | New  | Fruit    | 10       | New Brand | 1.99  |
    When Click on save product button on product page
    Then Verify display product error message
      | Field Name                                  |
      | This field must have more than 8 characters |

  @104
  Scenario: User add new product unsuccessfully in case user enter product name has not enough length
    When Fill product form with data
      | Name             | Category | Quantity | Brand | Price |
      | New Test Product | Fruit    | 10       | New   | 1.99  |
    When Click on save product button on product page
    Then Verify display product error message
      | Field Brand                                 |
      | This field must have more than 6 characters |
