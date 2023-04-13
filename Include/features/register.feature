@1_register
Feature: User Registration Mobile

  @register
  Scenario: User Register using correct credential
    Given User already open aplication secondhand
    And User already on home page
    When User taps akun on the menu navigation
    And User taps login masuk button
    And User taps the Daftar link under the Masuk button
    And User inputs complete name in the field nama
    And User inputs an email according to the email format in the field
    And User inputs Password in the field with six character
    And User inputs Phone Number on the field
    And User inputs City on the field kota
    And User inputs Address on the field alamat
    And User taps Daftar button
    Then User successfully registers

  @negative_case
  Scenario Outline: User Registration with Incorrect Credentials
    Given User already open aplication secondhand
    And User already on home page
    When User taps akun on the menu navigation
    And User taps login masuk button
    And User taps the Daftar link under the Masuk button
    And User inputs <name_case> name in the field nama
    And User inputs the email field with <email_case>
    And User inputs Password in the field <password_case>
    And User inputs Phone Number on the field
    And User inputs City on the field kota
    And User inputs Address on the field alamat
    And User taps Daftar button
    Then User failed to register and should see warning information that <warning>

    Examples: 
      | code_id | name_case| email_case               | password_case               | warning                       |
      |     001 | empty    | an email according format| with six character          | nama tidak boleh kosong       |
      |     002 | complete | invalid email            | with six character          | email tidak valid             |
      |     003 | complete | registered email         | with six character          | Email sudah digunakan         |
      |     004 | complete | an email according format| with less then six character| Password harus lebih dari enam|
