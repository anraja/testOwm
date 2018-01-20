Feature: Get data by cordinates

  Background:
    Given a api key to retrieve data

  Scenario: User calls weather api to get data by valid cordinates
    When a user retrieves the data by cordinates latitude 35 and longitude 139
    Then the status code is 200
    And response includes the following
      | coord.lat			   | 35  |
      | coord.lon		   | 139 |


  Scenario: User calls weather api to get data by invalid cordinates
    When a user retrieves the data by cordinates latitude "abc" and longitude "abc"
    Then the status code is 400
    And response includes the following
      | message			   | abc is not a float  |
