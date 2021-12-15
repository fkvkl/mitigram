@regression
Feature: Careers page

  Background:
    Given user navigates to Careers page

  @low
  Scenario: Verify that user can display Open positions
    When user clicks Open positions
    Then user should be able to display Open positions

  @medium
  Scenario Outline: Verify that user can filter positions by categories
    When user selects "<category>"
    Then user should be able to display only positions contain "<keyword>"
    Examples:
      | category    | keyword  |
      | Engineering | Engineer |
      | Legal       | Legal    |

  @high
  Scenario Outline: Verify that user can check position details
    When User clicks "<position>" and then Learn more
    Then User should be able to display "<job description>"

    Examples:
      | position                    | job description                                                     |
      | Back-end Software Engineer  | https://www.mitigram.com/images/ads/Back-End_Software_Engineer.pdf  |
      | Front-end Software Engineer | https://www.mitigram.com/images/ads/Front-End_Software_Engineer.pdf |
      | Test Engineer               | https://www.mitigram.com/images/ads/Test_Engineer.pdf               |
      | Test Automation Engineer    | https://www.mitigram.com/images/ads/Test_Automation_Engineer.pdf    |
      | Legal Counsel               | https://www.mitigram.com/images/ads/Legal_Counsel.pdf               |

  @high
  Scenario Outline: Verify that user can apply to a position
    When User clicks "<position>" and Apply for this position
    Then User should be able to navigate to Contact page and page title should be "Contact"

    Examples:
      | position                 |
      | Test Automation Engineer |