Feature: View existing playlists

  @acceptance
  Scenario: view 2 existing posts

    Given posts "My first post for testing","My second post for testing" were created
    And user is logged in to Facebook

    When user navigated to the test page
    Then "My first post for testing", "My second post for testing" posts are shown
