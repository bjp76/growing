package biju.joseph.growing.contacts.steps;
import static org.junit.Assert.assertTrue;

import biju.joseph.growing.contacts.connector.WebConnector;
import biju.joseph.growing.contacts.pages.ViewAllContactsPage;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.*;
import cucumber.runtime.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Biju Joseph
 *         Created on : 10/8/12 8:13 AM
 */
public class ViewAllContactsStepDef {

    private ViewAllContactsPage contactsPage;

    @Before
    public void prepare(){
         WebConnector.createIEDriver();
    }

    @After
    public void cleanup(){
        WebConnector.closeDriver();
    }

    @Given("^I am a user of the Contacts$")
    public void I_am_a_user_of_the_Contacts() throws Throwable {
        contactsPage = new ViewAllContactsPage(WebConnector.currentDriver());
    }

    @When("^I access the index page$")
    public void I_access_the_index_page() throws Throwable {
        contactsPage.openAndWait();
    }

    @Then("^I should see the message 'No contacts available'$")
    public void I_should_see_the_message_No_contacts_available() throws Throwable {
        boolean noContactsPresent = contactsPage.hasNoContactsAvailableMessage();
        assertTrue(noContactsPresent);
    }

}
