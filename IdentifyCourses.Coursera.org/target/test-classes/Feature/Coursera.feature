Feature: Coursera Website Automation
	Scenario: Search WebDevelopment and retrieve info of first two course card
		Given I open the Coursera.org home page
		When I search Web Development
		And I apply filters for English language and Beginner level
		Then I should retrieve details of the first two course cards
		
	Scenario: Search Language Learning and get all languages
		Given I am on the Web Development page and go back to the Coursera.org home page
		When I search Language Learning
		Then I should retrieve all the languages
	
	Scenario: Submit invalid form on Coursera.org For Enterprise page
		Given I am on the Cousera.org page and I navigate to For Enterprise Page
		When I am on Enterprise page I scroll to Form
		When I fill the contact form with invalid details like firstName, lastName, email, phoneNo, title, name
		And I click on submit button
		Then I should capture the error message
		
	 