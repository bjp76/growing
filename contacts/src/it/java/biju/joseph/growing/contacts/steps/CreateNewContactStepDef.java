package biju.joseph.growing.contacts.steps;

import biju.joseph.growing.contacts.connector.WebConnector;
import biju.joseph.growing.contacts.pages.EditContactPage;
import biju.joseph.growing.contacts.pages.ViewAllContactsPage;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;

import static org.junit.Assert.*;

/**
 * @author Biju Joseph
 *         Created on : 10/8/12 8:41 AM
 */
public class CreateNewContactStepDef {

    private ViewAllContactsPage contactsPage;
    private EditContactPage newContactPage;

    @Before
    public void prepare(){
        WebConnector.currentDriver();
    }

    @After
    public void cleanup(){
        WebConnector.closeDriver();
    }

    @Given("^I am in view all contacts page$")
    public void I_am_in_view_all_contacts_page() throws Throwable {
        contactsPage = new ViewAllContactsPage(WebConnector.currentDriver());
        contactsPage.openAndWait();
    }

    @When("^I click on 'New Contact' button$")
    public void I_click_on_New_Contact_button() throws Throwable {
        contactsPage.clickNewContactButton();
    }

    @Then("^I should see empty 'Edit Contact Form'$")
    public void I_should_see_empty_Edit_Contact_Form() throws Throwable {
        newContactPage = new EditContactPage(WebConnector.currentDriver());
        assertTrue(newContactPage.isBlankEditForm());
    }

    @When("^I populate the form with:$")
    public void I_populate_the_form_with(DataTable table) throws Throwable {
        String name = table.getGherkinRows().get(0).getCells().get(1);
        String dob = table.getGherkinRows().get(1).getCells().get(1);
        String address = table.getGherkinRows().get(2).getCells().get(1);
        String email = table.getGherkinRows().get(3).getCells().get(1);
        String mobile = table.getGherkinRows().get(4).getCells().get(1);
        newContactPage.fillForm(name, dob, address, email, mobile);
    }

    @When("^I click 'Save' button$")
    public void I_click_Save_button() throws Throwable {
        newContactPage.clickSaveButton();
    }

    @Then("^I should see view all contacts page with '(.*)' in it.$")
    public void I_should_see_view_all_contacts_page_with_Joel_Biju_Joseph_in_it(String name) throws Throwable {
        assertTrue(contactsPage.hasContactWithGivenName(name));
    }
    @When("^I click on 'Delete' link$")
    public void I_click_on_Delete_link() throws Throwable {
         contactsPage.clickDeleteLink();
    }

    @Then("^I should see a Delete confirmation$")
    public void I_should_see_a_Delete_confirmation() throws Throwable {

    }

    @When("^I answer 'No'$")
    public void I_answer_No() throws Throwable {
        contactsPage.onDeleteConfirmBoxClickCancel();
    }

    @Then("^I should still see view all contacts page with '(.*)' in it$")
    public void I_should_still_see_view_all_contacts_page_with_Joel_Biju_Joseph_in_it(String name) throws Throwable {
        assertTrue(contactsPage.hasContactWithGivenName(name));
    }

    @When("^I answer 'Yes'$")
    public void I_answer_Yes() throws Throwable {
       contactsPage.onDeleteConfirmBoxClickOk();
    }

    @Then("^I should not see view all contacts page without '(.*)' in it.$")
    public void I_should_not_see_view_all_contacts_page_without_Joel_Biju_Joseph_in_it(String name) throws Throwable {
        assertFalse(contactsPage.hasContactWithGivenName(name));
    }


}
