Feature: Registering for an account and adding a item to cart
Background: User navigates to dashboard
  Given User is on the website

  Scenario: User should be able to register
    Given User navigates to login page and signs up
    And user is on the signupPage
    When User registers with valid credentials
    Then user should see the success message

  Scenario: User should be able to add a new item to cart
    Given user navigates to products page
    Then user clicks view product and clicks add to cart
    When user navigates to cart
    Then user should see the item that added to cart









