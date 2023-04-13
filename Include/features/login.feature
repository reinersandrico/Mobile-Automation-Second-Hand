@2_login
Feature: Login feature Mobile

	@positive_case
  Scenario: User want to login using correct email dan password
  Given User already open aplication secondhand
  And User already on home page
  When User taps akun on the menu navigation
  And User taps login masuk button
  And User input email "reiner.sandrico1@gmail.com"
  And User input password "123456789"
  And User taps login button
  Then User successful login and redirected account page
  
	@negative_case
  Scenario Outline: User want login using inccorect cridentias
    Given User already open aplication secondhand
    And User already on home page
    When User taps akun on the menu navigation
    And User taps login masuk button
    And User input email in the fields <email>
    And User input password in the fields <password>
    And User taps login button
    Then User unsuccessfully login and get <result>

    Examples: 
      | case_Id | email                   | password    |	result				|
      |     001 | valid email 						| 1234567899  | error message	|
      |			002	| invalid									| invalid 		| error message	|
      |			003	| wahyu@gmail.com					| invalid     | error message	|
      |			004	| empty										| invalid     | empty					|
      |			005	| valid										| empty				|	empty					|
      |			006	| empty										| empty				| empty					|
