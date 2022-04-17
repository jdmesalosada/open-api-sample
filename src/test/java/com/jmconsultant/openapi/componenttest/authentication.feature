Feature: User can consume the service when he is authenticated
  Background:
    * url baseUrl

  Scenario: User sends valid credentials
    * def login_request =
    """
    {
    "billId": "00045677",
    "pass": "123Valid"
    }
    """
    Given path '/authentication/login'
    And request login_request
    When method POST
    Then status 200
    And match response.customerSince == '2018-11-07'
    And match response.name == 'Julian Mesa'

  Scenario: User doesn't send the id bill
    * def bill_without_id_request =
    """
    {
    "pass": "123Valid"
    }
    """
    Given path '/authentication/login'
    And request bill_without_id_request
    When method POST
    Then status 409