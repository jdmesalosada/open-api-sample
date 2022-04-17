Feature: Get test for bankproducts by id
  Background:
    * url baseUrl

  Scenario: Get existent bank product
    Given path '/authentication/login'
    When method POST
    Then status 200
    And match response == {"id":1,"title":"My product"}