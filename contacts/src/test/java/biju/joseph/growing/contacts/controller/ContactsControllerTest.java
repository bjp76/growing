package biju.joseph.growing.contacts.controller;

import biju.joseph.growing.contacts.domain.Contact;
import biju.joseph.growing.contacts.domain.ContactValidator;
import biju.joseph.growing.contacts.repository.ContactRepository;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Biju Joseph
 *         Created on : 10/7/12 7:35 PM
 */
public class ContactsControllerTest {
    private ContactsController controller;
    private ContactRepository repository;
    private ContactValidator validator;
    List<Contact> contacts;

    @Before
    public void setUp() throws Exception {
        controller = new ContactsController();
        repository = EasyMock.createMock(ContactRepository.class);
        validator = EasyMock.createMock(ContactValidator.class);
        controller.setContactRepository(repository);
        controller.setValidator(validator);
        contacts = new ArrayList<Contact>();
    }

    @Test
    public void testInitBinder() throws Exception {
        WebDataBinder binder = EasyMock.createMock(WebDataBinder.class);
        binder.registerCustomEditor(EasyMock.eq(Date.class), (CustomDateEditor) EasyMock.anyObject());
        EasyMock.replay(binder);
        controller.initBinder(binder);
        EasyMock.verify(binder);
    }

    @Test
    public void testSearchContacts() throws Exception {

        EasyMock.expect(repository.searchContacts("x")).andReturn(contacts);
        EasyMock.replay(repository);
        ModelAndView mv = controller.searchContacts("x");
        EasyMock.verify(repository);
        assertEquals("showContacts", mv.getViewName());
        assertSame(contacts, mv.getModel().get("contacts"));
    }

    @Test
    public void testGetAllContacts() throws Exception {
        EasyMock.expect(repository.getAllContacts()).andReturn(contacts);
        EasyMock.replay(repository);
        ModelAndView mv = controller.getAllContacts();
        EasyMock.verify(repository);
        assertEquals("showContacts", mv.getViewName());
        assertSame(contacts, mv.getModel().get("contacts"));
    }

    @Test
    public void testNewUserForm() throws Exception {
        ModelAndView mv = controller.newUserForm();
        assertEquals("newContact", mv.getViewName());
        assertNotNull(mv.getModel().get("newContact"));
    }

    @Test
    public void testCreateWhenError() throws Exception {
        Contact contact = new Contact();
        BindingResult bindingResult = EasyMock.createMock(BindingResult.class);
        validator.validate(contact, bindingResult);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(true);
        EasyMock.replay(bindingResult, validator);
        assertEquals("newContact", controller.create(contact, bindingResult, null));
        EasyMock.verify(validator, bindingResult);
    }

    @Test
    public void testCreate() throws Exception {
        Contact contact = new Contact();
        BindingResult bindingResult = EasyMock.createMock(BindingResult.class);
        SessionStatus status = EasyMock.createMock(SessionStatus.class);
        validator.validate(contact, bindingResult);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(false);
        EasyMock.expect(repository.save(contact)).andReturn(1);
        status.setComplete();
        EasyMock.replay(bindingResult, validator, status, repository);
        assertEquals("redirect:viewAllContacts.do", controller.create(contact, bindingResult, status));
        EasyMock.verify(validator, bindingResult, status, repository);
    }

    @Test
    public void testEdit() throws Exception {
        Contact contact = new Contact();
        EasyMock.expect(repository.getById(1)).andReturn(contact);
        EasyMock.replay(repository);
        ModelAndView mv = controller.edit(1);
        EasyMock.verify(repository);
        assertEquals("editContact", mv.getViewName());
        assertSame(contact, mv.getModel().get("editContact"));
    }

    @Test
    public void testEditInvalidId() throws Exception {
        Contact contact = new Contact();
        EasyMock.expect(repository.getById(1)).andReturn(null);
        EasyMock.replay(repository);
        ModelAndView mv = controller.edit(1);
        EasyMock.verify(repository);
        assertEquals("editContact", mv.getViewName());
        assertNull(mv.getModel().get("editContact"));
    }


    @Test
    public void testUpdateInvalid() throws Exception {
        Contact contact = new Contact();
        BindingResult bindingResult = EasyMock.createMock(BindingResult.class);
        validator.validate(contact, bindingResult);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(true);
        EasyMock.replay(bindingResult, validator);
        assertEquals("editContact", controller.update(contact, bindingResult, null));
        EasyMock.verify(validator, bindingResult);
    }

    @Test
    public void testUpdate() throws Exception {
        Contact contact = new Contact();
        BindingResult bindingResult = EasyMock.createMock(BindingResult.class);
        SessionStatus status = EasyMock.createMock(SessionStatus.class);
        validator.validate(contact, bindingResult);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(false);
        repository.update(contact);
        status.setComplete();
        EasyMock.replay(bindingResult, validator, status, repository);
        assertEquals("redirect:viewAllContacts.do", controller.update(contact, bindingResult, status));
        EasyMock.verify(validator, bindingResult, status, repository);
    }


    @Test
    public void testDelete() throws Exception {
        repository.delete(2);
        EasyMock.replay(repository);
        assertEquals("redirect:viewAllContacts.do", controller.delete(2).getViewName());
        EasyMock.verify(repository);
    }
}
