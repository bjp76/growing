package biju.joseph.growing.contacts.domain;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.Errors;

import static org.junit.Assert.*;

/**
 * @author Biju Joseph
 *         Created on : 10/7/12 7:28 PM
 */
public class ContactValidatorTest {

    ContactValidator validator;
    Errors errors;
    @Before
    public void setUp(){
        validator = new ContactValidator();
        errors = EasyMock.createMock(Errors.class);
    }
    @Test
    public void testSupports() throws Exception {
      assertTrue( validator.supports(Contact.class) );
      assertFalse(validator.supports(String.class));
    }

    @Test
    public void testValidate() throws Exception {
        EasyMock.expect(errors.getFieldValue("name")).andReturn("Biju");
        EasyMock.replay(errors);
        validator.validate(new Contact(), errors);
        EasyMock.verify(errors);

    }
    @Test
    public void testValidateWhenNameIsNull() throws Exception {
        EasyMock.expect(errors.getFieldValue("name")).andReturn(null);
        errors.rejectValue("name", "required.name", null, "Name is required.");
        EasyMock.replay(errors);
        validator.validate(new Contact(), errors);
        EasyMock.verify(errors);

    }
    @Test
    public void testValidateWhenNameIsEmpty() throws Exception {
        EasyMock.expect(errors.getFieldValue("name")).andReturn("");
        errors.rejectValue("name", "required.name", null, "Name is required.");
        EasyMock.replay(errors);
        validator.validate(new Contact(), errors);
        EasyMock.verify(errors);

    }
}
