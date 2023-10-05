#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase Products
  As a user
  I want to be able to add two or more products to the cart
  So that I can proceed with the purchase by placing the order

  @tag1
  Scenario Outline: Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for "<firstProduct>" and add it to the cart
    And I search for "<secondProduct>" and add it to the cart
    And I proceed to the cart
    And I review the cart items
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<mounth>" and "<year>"
    Then I should see a confirmation "<message>"

    Examples:
      | firstProduct | secondProduct | message                |
      | student      | Password123   | Logged In Successfully |

