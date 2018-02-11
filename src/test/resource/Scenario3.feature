@scenario3
Feature: Property Finder Automation

  Scenario Outline: User searches for agent on property finder website
    Given the user wants to find an agent on <country>
    When the user clicks on agent tab
    And the user selects first agent
    Then the user can capture the agent info and write the info in text file
    And the user can capture screenshot of the page
    And the user changes the language to <page_language>
    Then the user can capture screenshot of the page

    Examples: 
      | country | page_language |
      | UAE     | Arabic        |
