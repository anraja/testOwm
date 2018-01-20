Feature: Get data by city id

  Background:
    Given a api key to retrieve data

  Scenario: User calls weather api to get data by valid city id
    When a user retrieves the data by city id 2172797
    Then the status code is 200
    And response includes the following
      | id 					    | 2172797			|
      | sys.country				| AU	            |

  Scenario: User calls weather api to get data by invalid city id
    When a user retrieves the data by city id "abc"
    Then the status code is 400
    And response includes the following
      | message			        | abc is not a city ID	        |


  Scenario: User calls weather api to get data by invalid city id
    When a user retrieves the data by city id 99
    Then the status code is 404
    And response includes the following
      | message			        | city not found	        |
