package biju.joseph.growing.contacts.repository;

/**
 * This class will manage the lifecycle of a Contact object
 * @author Biju Joseph
 *         Created on : 10/7/12 6:20 PM
 */

import java.util.List;

import biju.joseph.growing.contacts.domain.Contact;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ContactRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Contact getById(int id) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Contact> searchContacts(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contact.class);
        criteria.add(Restrictions.ilike("name", name + "%"));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Contact> getAllContacts() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contact.class);
        return criteria.list();
    }

    public int save(Contact Contact) {
        return (Integer) sessionFactory.getCurrentSession().save(Contact);
    }

    public void update(Contact Contact) {
        sessionFactory.getCurrentSession().merge(Contact);
    }

    public void delete(int id) {
        Contact c = getById(id);
        sessionFactory.getCurrentSession().delete(c);
    }

    @Required
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}