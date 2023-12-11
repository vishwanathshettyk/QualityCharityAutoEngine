Feature: Test Playwright

  Scenario Outline: Validate Playwright search dialog
    When login page is opened
    When fill "shetty.vishwa@gmail.com" in userName box
    And fill "HubGit@23" in password box
    And clicks on singIn button
    Given home_page page is opened
    When clicks on getStarted button
    Then get_started page is opened
    When clicks on writing_test link
    And clicks on search_button button
    And wait for 3 seconds
    And fill "<textToFill>" in search_box box
    And wait for 3 seconds
    And clicks on run_test link
    And wait for 2 seconds
    Then browsers_page page is opened
    Examples:
      | textToFill                      |
      | Run tests on different browsers |
      | Assertion                       |

