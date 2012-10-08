package biju.joseph.growing.contacts.repository;

import biju.joseph.growing.contacts.domain.Contact;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * This Unit test will test the functionality of the ContactRepository by mocking.
 *
 * @author Biju Joseph
 *         Created on : 10/7/12 6:25 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:core-context.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
@Transactional
public class ContactRepositoryTest {


    @Autowired
    public SessionFactory sessionFactory;

    @Autowired
    ContactRepository contactRepository;

    @Test
    @DatabaseSetup("sample-contacts.xml")
    public void testGetById() throws Exception {
        Contact contact = contactRepository.getById(-1);
        assertNotNull(contact);
        assertEquals("Julianne", contact.getName());
        assertEquals("13815 Jefferson Park Dr Herndon VA 20171", contact.getAddress());

    }

    @Test
    @DatabaseSetup("sample-contacts.xml")
    public void testSearchContacts() throws Exception {
        List<Contact> contacts = contactRepository.searchContacts("Manju");
        assertEquals(1, contacts.size());
        assertEquals(-2, contacts.get(0).getId());
    }

    @Test
    @DatabaseSetup("sample-contacts.xml")
    public void testGetAllContacts() throws Exception {
        List<Contact> contacts = contactRepository.getAllContacts();
        assertEquals(3, contacts.size());
        assertEquals("Joel", contacts.get(0).getName());
    }

    @Test
    @Transactional
    public void testSave() throws Exception {
        //save a contact
        {
            Contact contact = Fixture.createContact("Biju", "12/29/1976", "x", "Male");
            contactRepository.save(contact);

        }
        interruptSession();
        //read it back
        {
            List<Contact> contacts = contactRepository.searchContacts("Biju");
            assertEquals(1, contacts.size());
            Contact contact = contacts.get(0);
            assertEquals("Biju", contact.getName());
            assertEquals("x", contact.getAddress());
            assertEquals(Fixture.date("12/29/1976"), contact.getDob());
            assertEquals("Male", contact.getGender());
            assertNull(contact.getMobile());
            assertNotNull(contact.getId());
        }
    }

    @Test
    @DatabaseSetup("sample-contacts.xml")
    @Transactional
    public void testUpdate() throws Exception {
        {
            List<Contact> contacts = contactRepository.searchContacts("Manju");
            Contact c = contacts.get(0);
            c.setName("Mary");
        }

        interruptSession();
        {
            List<Contact> contacts = contactRepository.searchContacts("Manju");
            assertEquals(1, contacts.size());
            Contact c = contacts.get(0);
            assertEquals(-2, c.getId());
            assertEquals("13815 Jefferson Park Dr Herndon VA 20171", c.getAddress());
        }

    }

    @Test
    @DatabaseSetup("sample-contacts.xml")
    public void testDelete() throws Exception {
        {
            Contact contact = contactRepository.getById(-1);
            assertNotNull(contact);
            contactRepository.delete(-1);
        }
        interruptSession();
        {
            Contact contact = contactRepository.getById(-1);
            assertNull(contact);
        }

    }


    public void interruptSession() {
        sessionFactory.close();
        sessionFactory.openSession();
    }
}
