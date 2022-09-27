Feature: Products

  This feature is responsible for testing product search and shopping cart

  Background:
    Given The user access to falabella home page

  @smokeTest
  Scenario Outline: Verify the product search by category
    When enter the search criteria "<criteria>"
    And select the category "<category>"
    Then verify the expected product "<product expected>" and the result "<visible>"
    Examples:
      | criteria | category     | product expected                   | visible |
      | apple    | Computadoras | iPad Mini Wi-Fi 64GB 6ta Gen. Pink | true    |
      | apple    | Audio        | Audífono Generico Lightning iPhone | true    |
      | apple    | Audio        | iPad Mini Wi-Fi 64GB 6ta Gen. Pink | false   |

  @smokeTest
  Scenario Outline: Verify the price of the product on the cart
    When enter and select the product "<product>"
    And add to the cart and open
    Then verify the price on the cart
    Examples:
      | product                 |
      | Smartwatc Vivoactive 4S |