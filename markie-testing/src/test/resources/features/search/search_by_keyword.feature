Feature: Search by keyword

  @green
  Scenario: Searching for 'green'
    Given user is researching things on the internet
    When user looks up "green"
    Then user should see information about "green"

  @red
  Scenario: Searching for 'red'
    Given user is researching things on the internet
    When user looks up "red"
    Then user should see information about "red"
