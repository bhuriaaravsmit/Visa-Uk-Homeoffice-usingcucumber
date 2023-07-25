Feature:Visa confirmation Test
  As user I want to check what visa is needed to visit UK from different country with different purposes.
@smoke
  Scenario: User should see the visa requirements if coming to UK from Australia for tourism.
    Given I am on homepage
    When I clicked on start button
    And I select the Nationality "Australia"
    And I clicked next button
    And I select reason is Tourism
    And I clicked next button
    Then I can see the message about visa requirements
@sanity
  Scenario: User should see visa requirements if chilean coming to UK for work and plan
  to staying for longer than six month
    Given I am on homepage
    When I clicked on start button
    And I select the Nationality "Chile"
    And I clicked next button
    And I select reason is work academic visit or business
    And I click on reason for travel next step button
    And I select intendent to stay for longer than six month "more"
    And I click on next step in duration of stay page
    And I selected health and care provision
    And I clicked on next button in work type page
    Then verify the visa requirement for this purpose
@regression
  Scenario: User should see visa requirements if China national coming to UK o join partner and staying for long
    Given I am on homepage
    When I clicked on start button
    And I select the Nationality "China"
    And I clicked next button
    And I select the reason to join family and partner
    And I click on reason for travel next step button
    And I selected immigration status "yes"
    And I click on immigration next button
    Then verify the message for visa requirement