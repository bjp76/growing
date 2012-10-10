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
    public void clickNewContactButton(){
       getElement("//input[@value='New Contact']").click();
    }

}
