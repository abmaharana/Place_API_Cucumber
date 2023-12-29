Feature:Test place API

  @AddPlace @Regression
  Scenario Outline: Verify if place is successfully added using addplace api
    Given add place payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" api with "post" http request
    Then the api call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Then verify place_id created maps to "<name>" using "GetPlaceAPI"

    Examples:
    |name     |language   |address      |
    |Swarg    |Hindi      |Bhubaneswar  |
    #|Kutir    |Odia       |Puri         |

  @DeletePlace @Abhishek @Regression
  Scenario: Verify delete api
    Given delete place payload
    When user calls "DeletePlaceAPI" api with "post" http request
    Then the api call is success with status code 200
    And "status" in response body is "OK"
    
#1
#2
#3
#4
#5