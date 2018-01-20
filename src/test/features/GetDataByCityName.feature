Feature: Get data by city name


  Background:
      Given a api key to retrieve data


  Scenario: User calls weather api to get data by valid city names

      When a user retrieves the data by city name "London"
      Then the status code is 200
      And response includes the following
      | name			        | London	        |

  Scenario: User calls weather api to get data by invalid city names

      When a user retrieves the data by city name "uk"
      Then the status code is 404
      And response includes the following
      | message			        | city not found	        |


  Scenario: User calls weather api to get data by invalid city names

    When a user retrieves the data by city name 56
    Then the status code is 404
    And response includes the following
      | message			        | city not found	        |
