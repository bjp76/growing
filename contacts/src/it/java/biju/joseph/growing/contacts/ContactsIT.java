package biju.joseph.growing.contacts;

/**
 * @author Biju Joseph
 *         Created on : 10/8/12 7:35 AM
 */
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"html:target/cucumber"}

)
public class ContactsIT {
}
