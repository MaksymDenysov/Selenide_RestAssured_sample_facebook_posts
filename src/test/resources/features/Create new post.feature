Feature: Create new post

  @acceptance
  Scenario: create single post

    Given user is logged in to Facebook
    And user navigated to the test page

    When user clicks on Create Post button
    Then Create Post dialog is shown

    When user enters "My simple post" post text
    And user presses publish Post button

    Then "My simple post" post is shown on the page
