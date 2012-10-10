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


    public synchronized static WebDriver currentDriver(){
        System.out.println("Calling current Driver");
        if(WebConnector.driver == null){
            System.out.println("Creating new driver");
            String browser = System.getenv().get("browser") == null ? "firefox" : System.getenv().get("browser");

            if(browser.equals("ie")) WebConnector.driver = new InternetExplorerDriver();
            if(browser.equals("chrome")) WebConnector.driver = new ChromeDriver();
            if(browser.equals("firefox")) WebConnector.driver = new FirefoxDriver();
        }
        return driver;
    }

    public synchronized static void closeDriver() {
        System.out.println("Closing current driver");
        if(WebConnector.driver == null) return;
        WebConnector.driver.close();
        WebConnector.driver = null;
        System.out.println("Closed driver");
    }

}
