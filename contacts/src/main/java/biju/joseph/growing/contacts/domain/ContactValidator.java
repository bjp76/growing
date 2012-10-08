package biju.joseph.growing.contacts.domain;

/**
 * @author Biju Joseph
 *         Created on : 10/7/12 7:20 PM
 */

import biju.joseph.growing.contacts.domain.Contact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("contactValidator")
public class ContactValidator implements Validator {
    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class klass) {
        return Contact.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object model, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Name is required.");
    }
}
