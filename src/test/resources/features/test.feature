Feature: Test Playwright

  Scenario: Navigate to Getting Started
    Given I open playwright URL
    Then page "Installation | Playwright" is open

  Scenario: Validate Search dailog
    Given I open playwright URL
    When "Run test" is searched
    Then search results are shown