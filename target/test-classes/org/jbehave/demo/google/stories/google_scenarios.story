Narrative:
In order to provide authentication functionality
As a development team
I want to make sure that log in page works as expected
					 
Scenario: 	Test log in page.
Given 		home google web page https://google.com
And 		google authentication form
When 		the user has entered wrong username\password
And 		log-in button has been pressed
Then 		the user should see corresponding error message