package biju.joseph.growing.contacts.pages;

import org.openqa.selenium.WebDriver;

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
}
