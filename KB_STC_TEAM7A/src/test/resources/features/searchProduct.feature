#Author: kullybhela@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step

Feature: Search for a Product
  
	As a user I want to be able to search for a product 
	So that I can add the product to the basket

  @RegressionTest
  Scenario Outline: Verify that when a user searches for a valid product and adds to the basket, the product is available in the basket
    Given when I am on the homepage
    When I enter "<validProduct>" into productBox and search for the product
    And I add the selected product to the basket
    And I go to the basket
    Then the basketProduct should contain "<validProduct>" 
    
    Examples: 
      | validProduct | 
      |   Keyboard   |
     
