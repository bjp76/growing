Feature: Create new contact
  As a user, I wish to add a contact
  So that I can see newly added contact.

Scenario: Create new contact
  Given I am in view all contacts page
  When  I click on 'New Contact' button
  Then  I should see empty 'Edit Contact Form'
  When  I populate the form with:
        |name|Joel Biju Joseph|
        |dob|05-08-2005|
        |address|13815 Jefferson Park Dr Herndon VA 20171 USA|
        |email|bijujoseph2@gmail.com|
        |mobile|+1 5712631173|
  And   I click 'Save' button
  Then  I should see view all contacts page with 'Joel Biju Joseph' in it.
  When  I click on 'Delete' link
  Then  I should see a Delete confirmation
  When  I answer 'No'
  Then  I should still see view all contacts page with 'Joel Biju Joseph' in it
  When  I click on 'Delete' link
  Then  I should see a Delete confirmation
  When  I answer 'Yes'
  Then  I should not see view all contacts page without 'Joel Biju Joseph' in it.