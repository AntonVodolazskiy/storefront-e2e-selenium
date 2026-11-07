Feature: Storefront shopping flow

  Scenario: Log in with valid credentials
    Given I am on the Sauce Demo login page
    When I log in as "standard_user" with password "secret_sauce"
    Then I should see the product catalog

  Scenario: Locked out user cannot log in
    Given I am on the Sauce Demo login page
    When I log in as "locked_out_user" with password "secret_sauce"
    Then I should see the login error "Sorry, this user has been locked out."

  Scenario: Add product to cart
    Given I am on the Sauce Demo login page
    And I log in as "standard_user" with password "secret_sauce"
    When I add the first product to the cart
    Then the cart badge should show 1 item

  Scenario: Complete checkout
    Given I am on the Sauce Demo login page
    And I log in as "standard_user" with password "secret_sauce"
    And I add the first product to the cart
    When I check out as "Test" "Customer" with postal code "12345"
    Then I should see the order confirmation
