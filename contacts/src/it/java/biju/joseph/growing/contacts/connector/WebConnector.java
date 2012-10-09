package biju.joseph.growing.contacts.connector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Biju Joseph
 *         Created on : 10/9/12 9:25 AM
 */
public class WebConnector {

    private static WebDriver driver;

    public static WebDriver createFirefoxDriver(){
        if(WebConnector.driver == null){
            System.out.print("Creating new Driver");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriver createChromeDriver(){
        if(WebConnector.driver == null){
            System.out.print("Creating new Driver");
            driver = new ChromeDriver();
        }
        return driver;
    }
    public static WebDriver createIEDriver(){
        if(WebConnector.driver == null){
            System.out.print("Creating new Driver");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    public static WebDriver currentDriver(){
        return driver;
    }

    public static void closeDriver() {
        System.out.println("Closing driver");
        WebConnector.driver.close();
        WebConnector.driver = null;
    }

}
