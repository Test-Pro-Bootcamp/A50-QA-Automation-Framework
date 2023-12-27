Feature: Login test
# testNg = suite

  Scenario: Login test with correct credentials
    When I login as user in Koel with "demo@class.com" and "te$t$tudent"
    Then I should be authorized in home page

    Scenario: Login incorrect credentials
      When I login as user in Koel with "undefinded" and "undefinded"
