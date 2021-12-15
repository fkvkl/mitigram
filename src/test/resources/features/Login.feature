@regression
Feature: Login page

  Background:
    Given User navigates to log in page

  @high
  Scenario: Verify that user can log in with valid credentials
    When User enters valid credentials and clicks Log in
    Then Page url should not be equal to "https://marketplace.mitigram.com/Account/Login?ReturnUrl=%2F"

  @high
  Scenario Outline: Verify that user can not log in with invalid credentials
    When User enters "<email>" and "<password>" and clicks Log in
    Then User should receive the "<notification>"
    Examples:

      | email            | password | notification                                                      |
      | user@example.com | 12345    | Invalid login attempt.                                            |
      | user@example.com |          | Password is required                                              |
      | user             | 12345    | The Email field is not a valid e-mail address.                    |
      |                  |          | Email is required\nThe Email field is not a valid e-mail address. |

  @high
  Scenario: Verify that user can use create an account module
    When User clicks Contact us
    Then User should be able to navigate to Contact page and page title should be "Contact"

  @high
  Scenario: Verify that user can use Forgot your password? module
    When User clicks Forgot your password?
    And User enters his-her email address to input box and clicks Email link
    And User should be able to display "Please check your email to reset your password. Back to Login" message

  @low
  Scenario Outline: Verify that user can navigate to mobile application providers
    When User clicks "<store>" icon
    Then User should be able to navigate store's "<webpage>"

    Examples:
      | store       | webpage                                                                |
      | AppStore    | https://apps.apple.com/app/mitigram/id1453993945                       |
      | Google Play | https://play.google.com/store/apps/details?id=com.mitigram.marketplace |