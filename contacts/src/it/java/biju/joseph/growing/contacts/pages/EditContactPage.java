package biju.joseph.growing.contacts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Biju Joseph
 *         Created on : 10/9/12 8:53 AM
 */
public class EditContactPage extends Page {

    public EditContactPage(WebDriver driver) {
        super(driver, "/saveContact.do");
    }

    public boolean isBlankEditForm(){
       boolean editForm = hasText("/html/body/table/tbody/tr/td/h3", "Edit Contact Form");
       if(editForm){
           WebElement nameField = getElement("//input[@name='name']");
           String value = nameField.getAttribute("value");
           return value == null || value.equals("");
       }
       return false;

    }
    public void fillForm(String name, String dob, String address, String email, String mobile){
        String xpath = "//input[@name='%s']";
        setInputFieldValue(String.format(xpath, "name"), name);
        setInputFieldValue(String.format(xpath, "dob"), dob);
        setInputFieldValue(String.format(xpath, "address"), address);
        setInputFieldValue(String.format(xpath, "email"), email);
        setInputFieldValue(String.format(xpath, "mobile"), mobile);
    }
    public void clickSaveButton(){
        getElement("//input[@value='Save']").click();
    }

}
