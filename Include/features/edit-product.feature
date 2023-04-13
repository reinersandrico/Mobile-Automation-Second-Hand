@5_edit_product
Feature: Edit Product Mobile Feature

  Background: 
    Given User already open aplication secondhand
    And User already on home page
    When User taps akun on the menu navigation
    And User taps login masuk button
    And User input email "reiner.sandrico1@gmail.com"
    And User input password "123456789"
    And User taps login button

  
  @edit_product_positive_case
  Scenario: User want to edit product using the correct all data product
  Given User already in account page
  When User taps list menu daftar jual saya
  And User taps categories product
  And User choose product want to edit and taps product
  And User change product name "Iphone 22"
  And user change product price "2300"
  And User selects the new product category
  And User changes the location of the product "Thailand"
  And User change product description "Produk Sudah Diedit"
  And User choose new image product
  And User taps perbarui produk button
  Then User successfully update product and redirected to the product list page
  And User edit the product back to the initial value
  
  @edit_product_negative_case
  Scenario Outline: User want to edit product using empty data
    Given User already in account page
    When User taps list menu daftar jual saya
    And User taps categories product
    And User choose product want to edit and taps product negative case
    And User User delete <data>
    And User taps perbarui produk button
    Then User unsuccessfully update product and get toast message <message>
    And User will not be directed to the product list page

    Examples: 
      | case_Id | data                      | message                            |
      |     001 | empty product name        | product name can't be empty        |
      |     002 | empty product price       | product price can't be empty       |
      |     003 | empty product location    | product location can't be empty    |
      |     004 | empty	product description | product description can't be empty |
