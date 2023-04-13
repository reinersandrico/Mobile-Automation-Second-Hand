@8_detail_product
Feature: View Detail Product at Website

  @positive_case
  Scenario: User want to see detail product without login
    Given User launch the app
    When User tap one of product in the list product
    Then User can see detail product page

  Scenario: User want to bid product without login
    Given User launch the app
    When User tap one of product in the list product
    And User tap Saya Tertarik dan Ingin Nego button
    Then User redirected to login page

  Scenario: User want to see detail product with login
    Given User already open aplication secondhand
    And User already on home page
  	When User taps akun on the menu navigation
  	And User taps login masuk button
		And User input email "trilikajayanti@gmail.com.co"
    And User input password "trilika"
    And User taps login button
    Then User successful login and redirected account page
    And User tap beranda button
    And User tap one of product in the list product
    Then User can see detail product page
