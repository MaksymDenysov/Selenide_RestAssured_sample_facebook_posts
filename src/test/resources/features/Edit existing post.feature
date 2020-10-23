Feature: Edit existing post

  @acceptance
  Scenario: edit single post

    Given post "My first post for testing" was created
    And user is logged in to Facebook

    When user navigated to the test page
    And user opens Edit post dialog
    And users enters "New text for the post" as new text for the post
    And user saves the post

    Then "New text for the post" post is shown on the page
