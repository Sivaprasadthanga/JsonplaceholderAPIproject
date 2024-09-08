Feature: Get data

@get

Scenario Outline: User want to get list of all users from the application

Given the user has the  REST API endpoint

When I send a GET request to the endpoint is "<Endpoint>"

Then the response status code will be 200

And the response content type should be as "application/json"

 	Examples:

 			| 		Endpoint			|

 			|     /posts/       |

 			|     /post/        |

