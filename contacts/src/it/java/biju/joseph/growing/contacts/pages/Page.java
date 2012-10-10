package biju.joseph.growing.contacts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Biju Joseph
 *         Created on : 10/9/12 8:58 AM
 */
public class Page {
    public static String BASE_APP_URL = "http://localhost:8080";
    protected WebDriver driver;
    protected String relativePath;

    public Page(WebDriver driver, String path){
        this.driver = driver;
        this.relativePath =  BASE_APP_URL + path;
    }

    public void openAndWait(){
        openAndWait(relativePath);
    }
    public void openAndWait(String location) {
        driver.get(location);
        // driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT,
        // 					  TimeUnit.MILLISECONDS);
    }

    public WebElement getElement(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }

    public boolean hasText(String xpath, String text){
        return getElement(xpath).getText().contains(text);
    }

    public void setInputFieldValue(String inputElementXpath, String value){
        getElement(inputElementXpath).sendKeys(value);
    }

}
