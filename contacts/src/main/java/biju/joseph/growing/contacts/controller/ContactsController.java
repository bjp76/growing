package biju.joseph.growing.contacts.controller;

/**
 * @author Biju Joseph
 *         Created on : 10/7/12 7:30 PM
 */

import biju.joseph.growing.contacts.domain.Contact;
import biju.joseph.growing.contacts.domain.ContactValidator;
import biju.joseph.growing.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ContactsController {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/searchContacts")
    public ModelAndView searchContacts(@RequestParam(required = false, defaultValue = "") String name) {
        ModelAndView mav = new ModelAndView("showContacts");
        List<Contact> contacts = contactRepository.searchContacts(name.trim());
        mav.addObject("contacts", contacts);
        return mav;
    }

    @RequestMapping("/viewAllContacts")
    public ModelAndView getAllContacts() {
        ModelAndView mav = new ModelAndView("showContacts");
        List<Contact> contacts = contactRepository.getAllContacts();
        mav.addObject("contacts", contacts);
        return mav;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.GET)
    public ModelAndView newUserForm() {
        ModelAndView mav = new ModelAndView("newContact");
        Contact contact = new Contact();
        mav.getModelMap().put("newContact", contact);
        return mav;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public String create(@ModelAttribute("newContact") Contact contact, BindingResult result, SessionStatus status) {
        validator.validate(contact, result);
        if (result.hasErrors()) {
            return "newContact";
        }
        contactRepository.save(contact);
        status.setComplete();
        return "redirect:viewAllContacts.do";
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("id") Integer id) {
        ModelAndView mav = new ModelAndView("editContact");
        Contact contact = contactRepository.getById(id);
        mav.addObject("editContact", contact);
        return mav;
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.POST)
    public String update(@ModelAttribute("editContact") Contact contact, BindingResult result, SessionStatus status) {
        validator.validate(contact, result);
        if (result.hasErrors()) {
            return "editContact";
        }
        contactRepository.update(contact);
        status.setComplete();
        return "redirect:viewAllContacts.do";
    }

    @RequestMapping("deleteContact")
    public ModelAndView delete(@RequestParam("id") Integer id) {
        ModelAndView mav = new ModelAndView("redirect:viewAllContacts.do");
        contactRepository.delete(id);
        return mav;
    }

    public ContactRepository getContactRepository() {
        return contactRepository;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactValidator getValidator() {
        return validator;
    }

    public void setValidator(ContactValidator validator) {
        this.validator = validator;
    }
}