@7_edit_profile
Feature: Edit Profile

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
  Scenario: User want to update name profile with correct data
    When User click profile icon
    And User click edit profile
    And User click field name
    And User edit name
    And User click Submit button
    Then User successfully edit profile

  @positive_case
  Scenario: User want to update number phone profile with correct data
    When User click profile icon
    And User click edit profile
    And User click field number phone
    And User edit number phone
    And User click Submit button
    Then User successfully edit profile

  @positive_case
  Scenario: User want to update city profile with correct data
    When User click profile icon
    And User click edit profile
    And User click field city
    And User edit address
    And User click Submit button
    Then User successfully edit profile

  @positive_case
  Scenario: User want to update address profile with correct data
    When User click profile icon
    And User click edit profile
    And User click field address
    And User edit address
    And User click Submit button
    Then User successfully edit profile
    
  @negative_case
  Scenario: User want to update name profile with empty data
    When User click profile icon
    And User click edit profile
    And User click field name
    And User clear name
    And User click Submit button
    Then User unsuccessfully edit profile

