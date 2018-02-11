@scenario1
Feature: Property Finder Automation

  Scenario Outline: User searches for property on property finder website
    Given the user wants to search for a property on <country>
    When the user searches for a <property_type> to <category>
    And the <property_type> has <min_bid> minimum and <max_bid> maximum bids
    And the <property_type> in <location> location
    And the user clicks find
    Then the user can see the results based on provided search cretieria
    And the user sorts the price from maximum price to lowest price
    Then the user saves all the prices in a csv file with format

    Examples: 
      | country | category | property_type | location  | min_bid | max_bid |
      | QA      | BUY      | Villa         | The Pearl |       3 |       7 |
