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
  Scenario Outline:Test1 Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for "<firstProduct>" and add it to the cart
    And I search for "<secondProduct>" and add it to the cart
    And I proceed to the cart
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<month>" and "<year>"
    Then I should see a confirmation "<message>"

    Examples:
      | firstProduct           | secondProduct       | name          | country         | city   | creditCard        | month   | year  |       message                |
      | Samsung galaxy s6      | Nexus 6             | Jhon          | United States   | Miami  | 1234 5678 9012 34 |   12    | 2023  | Thank you for your purchase! |

  @tag2
  Scenario Outline:Test2 Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for "<firstProduct>" and add it to the cart
    And I search for "<secondProduct>" and add it to the cart
    And I search for "<thirdProduct>" and add it to the cart
    And I search for "<fourthProduct>" and add it to the cart
    And I search for "<fifthProduct>" and add it to the cart
    And I proceed to the cart
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<month>" and "<year>"
    Then I should see a confirmation "<message>"

    Examples:
      | firstProduct           | secondProduct       | thirdProduct                    | fourthProduct       | fifthProduct           | name          | country         | city   | creditCard        | month   | year  |       message                |
      | Samsung galaxy s6      | Nokia lumia 1520             | Samsung galaxy s6      | Sony vaio i5             | HTC One M9      | Jhon          | United States   | Miami  | 1234 5678 9012 34 |   12    | 2023  | Thank you for your purchase! |

  @tag3
  Scenario Outline:Test3 Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for "<firstProduct>" and add it to the cart
    And I search for "<firstProduct>" and add it to the cart
    And I search for "<firstProduct>" and add it to the cart
    And I search for "<firstProduct>" and add it to the cart
    And I search for "<firstProduct>" and add it to the cart
    And I proceed to the cart
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<month>" and "<year>"
    Then I should see a confirmation "<message>"

    Examples:
      | firstProduct           | name          | country         | city   | creditCard        | month   | year  |       message                |
      | Samsung galaxy s6      | Jhon          | United States   | Miami  | 1234 5678 9012 34 |   12    | 2023  | Thank you for your purchase! |

  @tag4
  Scenario Outline:Test4 Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for "<firstProduct>" and add it to the cart
    And I click in categories "<firstCategories>"
    And I search for "<secondProduct>" and add it to the cart
    And I click in categories "<secondCategories>"
    And I search for "<thirdProduct>" and add it to the cart
    And I click in categories "<thirdCategories>"
    And I search for "<fourthProduct>" and add it to the cart
    And I proceed to the cart
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<month>" and "<year>"
    Then I should see a confirmation "<message>"

    Examples:
      | firstProduct           | secondProduct       | thirdProduct           | fourthProduct       |  firstCategories  |  secondCategories |  thirdCategories        | name          | country         | city   | creditCard        | month   | year  |       message                |
      | Samsung galaxy s6       | Nokia lumia 1520    | Sony vaio i7           | ASUS Full HD        |   Phones          |   Laptops         |   Monitors              | Jhon          | United States   | Miami  | 1234 5678 9012 34 |   12    | 2023  | Thank you for your purchase! |


  #@tag5
  #Scenario Outline:Test5 Add Products to Cart and Place Order
   # Given I am on the shopping website
    #When I search for "<product>" and add it to the cart
     # Then I should see a confirmation "<message>"

    #Examples:
     # | product               |       message  |
      #| Samsung galaxy s6      | success |
      #| Samsung galaxy s6      | success |
      #| Samsung galaxy s6      | success |
      #| Samsung galaxy s6      | success |