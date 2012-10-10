package biju.joseph.growing.contacts;

/**
 * @author Biju Joseph
 *         Created on : 10/8/12 7:35 AM
 */
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"html:target/cucumber"} ,
        features = {
                "classpath:biju/joseph/growing/contacts/a_view_all_contacts.feature",
                "classpath:biju/joseph/growing/contacts/b_create_new_contact.feature"
        }
)
public class ContactsIT {
}
