package biju.joseph.growing.contacts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Biju Joseph
 *         Created on : 10/9/12 8:53 AM
 */
public class ViewAllContactsPage extends Page{


    public ViewAllContactsPage(WebDriver driver){
        super(driver, "/viewAllContacts.do");
    }

    public boolean hasNoContactsAvailableMessage(){
        WebElement content = driver.findElement(By.tagName("body"));
        System.out.println(content.getText());
        return content.getText().contains("There are no contacts available in the system. Click on Add New Contact button to create a new contact.");
    }
}
