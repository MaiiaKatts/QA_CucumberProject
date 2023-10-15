Feature: HomePage UI

  @navigate
#  название сценария
  Scenario: Verify HomePage title is displayed
#    описываем шаги пользователя
    Given User launches FirefoxBrowser
    When User opens ilcarro HomePage
    Then User verifies HomePage title