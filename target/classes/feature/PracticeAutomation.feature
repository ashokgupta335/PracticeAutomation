Feature: PracticeAutomation
In order to shop the Automation books 
As a practice automation user
I want to connect with the practice automation application

Background: common for each scenario
      Given User launch the browser with practiceautomationtestingPage





Scenario: Filling Details in registration form
When I fill the form by using below data
|firstName|lastName|address|email|number|skill|workCountry|presentCountry|birthYear|birthMonth|birthDay|password|confirmPassword|
|ashok|koli|main road,village|asdf@gmail.com|9895989598|AutoCAD|India|India|1997|November|15|Ashok@335|Ashok@335|
Then Assert for the firstname text box


Scenario: Giving country name by AutoComplete
When I hover to widgets and click on AutoComplete and filled the two country names as 'ind' and 'mal'
Then the box should contains the given two country names


Scenario: Get alerts
When I hover to switchTo and click on alerts
Then I should get a alert


Scenario: Lauching Bootstrap modal page
When I hover to more and click on modals
Then I should get a page with 'Bootstrap Modals' title


Scenario: Playing a video
When I hover to video and click vimeo and click on video screen
Then Video should play


