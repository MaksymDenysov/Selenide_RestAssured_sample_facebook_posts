Feature: Delete post

  @acceptance
  Scenario: delete one post

    Given posts "My first post for testing","My second post for testing" were created
    And user is logged in to Facebook
    And user navigated to the test page
    And amount of posts is 2

    When user deletes post number 1
    Then amount of posts is 1
    And "My first post for testing" post is shown on the page