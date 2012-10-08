package biju.joseph.growing.contacts.repository;

import biju.joseph.growing.contacts.domain.Contact;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A mother object that generates quickly some test objects.
 * @author Biju Joseph
 *         Created on : 10/7/12 6:15 PM
 */
public class Fixture {

    public static Contact createContact(String name, String dob, String address, String gender) throws ParseException{
        Contact c = new Contact();
        c.setName(name);
        c.setAddress(address);
        c.setDob(date(dob));
        c.setGender(gender);
        return c;
    }

    public static Date date(String mmddyyyy) throws ParseException {
       SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
       return df.parse(mmddyyyy);

    }
}
