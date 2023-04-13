@4_add-product
Feature: Add Product Feature Mobile

	Background: User do the login process
    Given User already open aplication secondhand
    When User already on home page
    And User taps akun on the menu navigation
    And User taps login masuk button
    And User input email "reiner.sandrico1@gmail.com"
    And User input password "123456789"
    And User taps login button
    Then User successful login and redirected account page
    
  @positive_case
	Scenario: User want to add new product
    When User click + button
    And User input product name
    And User input product price
    And User choose the category 
    And User input location
    And User input description
    And User browse and choose product photo
    And User click Terbitkan button
    Then User Should be Redirected to Daftar Jual Saya page

@negative_case
	Scenario Outline: User cannot add new product
		When User click + button
    And User input registration product field with empty <condition>
    And User click Terbitkan button
		Then User should be able to see warning on <condition> field
    Examples:
        | case_id |     condition     |       
        | C01     |				name				|
        | C02     | 			price				|
        | C03     | 	 description 		|