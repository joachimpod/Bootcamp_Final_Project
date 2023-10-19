@tag
Feature: Purchase Products
  As a user
  I want to be able to add two or more products to the cart
  So that I can proceed with the purchase by placing the order

  @tag_buy_two_products
  Scenario Outline:Test1 Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for "<firstProduct>" and add it to the cart
    And I proceed to the cart
    And I should see the "<firstProduct>" in the shop cart
    And I search for "<secondProduct>" and add it to the cart
    And I proceed to the cart
    And I should see the "<secondProduct>" in the shop cart
    And I proceed to the cart
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<month>" and "<year>"
    Then I should see a confirmation "<message>"
    And I check if the data its correct with "<name>" and "<creditCard>"

    Examples:
      | firstProduct           | secondProduct       | name          | country         | city   | creditCard        | month   | year  |       message                |
      | Samsung galaxy s6      | Nexus 6             | Jhon          | United States   | Miami  | 1234 5678 9012 34 |   12    | 2023  | Thank you for your purchase! |

  @tag_buy_different_products
  Scenario Outline:Test2 Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for multiple "<product>" and add it to the cart
    And I proceed to the cart
    And I should see the "<product>" in the shop cart
    And I proceed to the cart
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<month>" and "<year>"
    Then I should see a confirmation "<message>"
    And I check if the data its correct with "<name>" and "<creditCard>"

    Examples:
      | product           | name          | country         | city   | creditCard        | month   | year  |       message                |
      | Samsung galaxy s6,Nokia lumia 1520,Samsung galaxy s6,Sony vaio i5,HTC One M9      | Jhon          | United States   | Miami  | 1234 5678 9012 34 |   12    | 2023  | Thank you for your purchase! |

  @tag_buy_the_same_product_multiple_times
  Scenario Outline:Test3 Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for multiple "<firstProduct>" and add it to the cart
    And I proceed to the cart
    And I should see the "<firstProduct>" in the shop cart
    And I proceed to the cart
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<month>" and "<year>"
    Then I should see a confirmation "<message>"
    And I check if the data its correct with "<name>" and "<creditCard>"

    Examples:
      | firstProduct           | name          | country         | city   | creditCard        | month   | year  |       message                |
      | Samsung galaxy,Samsung galaxy s6,Samsung galaxy s6,Samsung galaxy s6,Samsung galaxy s6,Samsung galaxy s6       | Jhon          | United States   | Miami  | 1234 5678 9012 34 |   12    | 2023  | Thank you for your purchase! |

  @tag_buy_different_category_products
  Scenario Outline:Test4 Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for "<firstProduct>" and add it to the cart
    And I proceed to the cart
    And I should see the "<firstProduct>" in the shop cart
    And I click in categories "<firstCategories>"
    And I search for "<secondProduct>" and add it to the cart
    And I proceed to the cart
    And I should see the "<secondProduct>" in the shop cart
    And I click in categories "<secondCategories>"
    And I search for "<thirdProduct>" and add it to the cart
    And I proceed to the cart
    And I should see the "<thirdProduct>" in the shop cart
    And I click in categories "<thirdCategories>"
    And I search for "<fourthProduct>" and add it to the cart
    And I proceed to the cart
    And I should see the "<fourthProduct>" in the shop cart
    And I proceed to the cart
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<month>" and "<year>"
    Then I should see a confirmation "<message>"
    And I check if the data its correct with "<name>" and "<creditCard>"

    Examples:
      | firstProduct           | secondProduct       | thirdProduct           | fourthProduct       |  firstCategories  |  secondCategories |  thirdCategories        | name          | country         | city   | creditCard        | month   | year  |       message                |
      | Samsung galaxy s6       | Nokia lumia 1520    | Sony vaio i7           | ASUS Full HD        |   Phones          |   Laptops         |   Monitors              | Jhon          | United States   | Miami  | 1234 5678 9012 34 |   12    | 2023  | Thank you for your purchase! |


  @tag_buy_list_of_products
  Scenario Outline:Test5 Add Products to Cart and Place Order
    Given I am on the shopping website
    And I search for multiple "<product>" and add it to the cart
    And I proceed to the cart
    And I should see the "<product>" in the shop cart
    And I proceed to the cart
    When I place the order with "<name>" and "<country>" and "<city>"  and "<creditCard>"  and "<month>" and "<year>"
    Then I should see a confirmation "<message>"
    And I check if the data its correct with "<name>" and "<creditCard>"

    Examples:
      | product                                        | name          | country         | city   | creditCard        | month   | year  |       message                |
      | Samsung galaxy s6,Nexus 6,Nokia lumia 1520     | Jhon          | United States   | Miami  | 1234 5678 9012 34 |   12    | 2023  | Thank you for your purchase! |
