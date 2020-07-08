# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As an api user I want to retrieve account details with zero followers

  Scenario: Find the one oldest user accounts with zero followers
    Given url microserviceUrl
    And path 'accounts/nofollower' 
    And param count = '1'
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation
    And match response == 
    """
    [{id:'#number',
    login:"#string",
    htmlUrl:"#string"
    }]
    """

