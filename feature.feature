Feature: Automate Form Authentication,Infinite Scroll internet heroukapp
Scenario: Login with correct username and wrong password
Given the user in the main page
When user clicks the form authentication link
Then user types correct username "test" and wrong password "test123"
Then clicks login button
And asserts the login validation

Scenario: Login with incorrect username and correct password
Given the user in the main page
When user clicks the form authentication link
Then user types incorrect username as "steyn" and correct password as "SuperSecretPassword!"
Then clicks login button
And asserts the login validation

Scenario: Login with correct username and correct password
Given the user in the main page
When user clicks the form authentication link
Then user types correct username as "smith" and correct password as "SuperSecretPassword!"
Then clicks login button
Then asserts the login validation
And after successfull login user logs out 

Scenario: Scroll down twice and Scroll up to the top of the page
Given the user in the main page
When User clicks Infinite Scroll link on the menu
Then Scroll down twice and Scroll up back to the top of the page
And Asserts Infinite Scroll text

Scenario: Key presses on menu and assert 
Given the user in the main page
When User clicks Key Presses link on the menu
And keypress keys & assert them 

