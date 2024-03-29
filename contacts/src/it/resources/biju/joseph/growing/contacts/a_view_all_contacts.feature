Feature: View All Contacts
  As a user, I want to access Contacts
  So that I can see all the available contacts.

Scenario: Simple index page loading
  Given I am a user of the Contacts
  When  I access the index page
  Then  I should see the message 'There are no contacts available in the system'
