@6_bid_product
Feature: bidproduct

  Background: 
    Given User launch the app
    When User taps akun on the menu navigation
    And User taps login masuk button
    And User input email "trilikajayanti@gmail.com.co"
    And User input password "trilika"
    And User taps login button
    Then User successful login and redirected account page
    And User tap beranda button
    And User tap one of product in the list product
    And User tap Saya Tertarik dan Ingin Nego button

  Scenario: User want to bid product with 1000 price
    And User input price in Harga Tawar field with "1000"
    And User tap Kirim button
    Then User can see Success message

  Scenario: User want to bid product with 0 price
    And User input price in Harga Tawar field with "0"
    And User tap Kirim button
    Then User can see Success message

  Scenario: User want to bid product with leave harga tawar
    And User tap Kirim button
    Then User can see failed message
    

