Feature: Login

  @login
#  название сценария
  Scenario: Login with valid data
#  описываем шаги пользователя
    Given User launches FirefoxBrowser
    When User opens ilcarro HomePage
    And User clicks on Log in link
    And User enters valid data
    And User clicks on Yalla button
    Then User verifies log in message
    And User quites browser

  @wrongPassword
#  название сценария
  Scenario Outline: Login with valid email and wrong password
#  описываем шаги пользователя
    Given User launches FirefoxBrowser
    When User opens ilcarro HomePage
    And User clicks on Log in link
    And User enters valid email and wrong password
    |email  |password  |
    |<email>|<password>|
    And User clicks on Yalla button
    Then User verifies error message
    And User quites browser

    Examples:
      | email               |password |
      |maiiaqwerty@gmail.com|Qwerty123|
      |maiiaqwerty@gmail.com|Ytrew$$$$|
      |maiiaqwerty@gmail.com|11111111$|
      |maiiaqwerty@gmail.com|$$$$$$$$$|