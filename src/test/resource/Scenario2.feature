@scenario2
Feature: Property Finder Automation

  Scenario Outline: User searches for agent on property finder website
    Given the user wants to find an agent on <country>
    When the user clicks on agent tab
    And the user wants an agent who can speak HINDI, ENGLISH and ARABIC langauages
    And the user clicks find agent
    Then the user can see the agent results based on provided search cretieria
    And the user notes down the total count of agents
    And the user adds further filter agents from <agent_country>
    And the user notes down the count of agents again
    Then assert that latest count is less than the previous count

    Examples: 
      | country | agent_country |
      | UAE     | India         |
