@4_add-product-no-login
Feature: Add Product Without Login

  @negative_case
  Scenario: User want to add new product without logging in
    Given User already open aplication secondhand
    And User already on home page
    When User click + button
    Then User will be redirected to add product page for logging in
