@3_logout
Feature: Logout Feature Mobile

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
Scenario: User want to logout from an account

    When User click akun icon
    And User click keluar button
    Then User should be redirected to home page