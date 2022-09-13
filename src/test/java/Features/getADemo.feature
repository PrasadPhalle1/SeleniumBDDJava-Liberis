Feature: feature to test get a demo functionality

  @HomePage
  Scenario: Click on get a demo on home page and verify partner selection page

    Given user is on home page
    When user clicks on get a demo button on home page
    Then verify the partner selection page

  @PartnerPage
  Scenario: Click on get a demo on partner page and verify validation message

    Given user is on become a partner page
    When user clicks on get a demo button on become a partner page
    Then verify the validation message

