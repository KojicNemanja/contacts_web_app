package my.contacts.database.hibernate.dao;

import my.contacts.database.hibernate.HibernateUtil;
import my.contacts.models.Contact;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public static int save(Contact contact){
        int generated_id = -1;
        Session session = HibernateUtil.openSession();
        try{
            session.getTransaction().begin();
            session.persist(contact);
            session.getTransaction().commit();
            generated_id = contact.getContact_id();
        }catch (Exception ex){
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
        }finally { session.close(); }
        return generated_id;
    }

    public static int edit(Contact contact){
        Contact edited_contact = null;
        Session session = HibernateUtil.openSession();
        try{
            session.getTransaction().begin();
            edited_contact = session.merge(contact);
            session.getTransaction().commit();
        }catch (Exception ex){
            edited_contact = null;
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
        }finally { session.close(); }
        if(edited_contact == null){
            return -1;
        }
        return edited_contact.getContact_id();
    }

    public static int delete(Contact contact){
        int result = -1;
        Session session = HibernateUtil.openSession();
        try{
            session.getTransaction().begin();
            session.remove(contact);
            session.getTransaction().commit();
            result = 1;
        }catch (Exception ex){
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        }finally{ session.close(); }
        return result;
    }

    public static int delete(int contact_id){
        Contact contact = get(contact_id);
        return delete(contact);
    }

    public static Contact get(int contact_id){
        String query = "FROM Contact WHERE contact_id=:input";
        Session session = HibernateUtil.openSession();
        return session.createQuery(query, Contact.class)
                .setParameter("input", contact_id)
                .getSingleResult();
    }

    public static List<Contact> getAll(int user_id){
        String query = "FROM Contact WHERE user_id=:input ORDER BY first_name";
        Session session = HibernateUtil.openSession();
        return session.createQuery(query, Contact.class)
                .setParameter("input", user_id).list();
    }

    public static List<Contact> getForPhrase(int user_id, String phrase){
        List<Contact> contacts = getAll(user_id);
        List<Contact> filteredContacts = new ArrayList<>();
        phrase = phrase.toLowerCase();
        for(Contact c : contacts){
            if(c.getFirst_name().toLowerCase().contains(phrase)
                    || c.getLast_name().toLowerCase().contains(phrase)
                    || c.getPhone().contains(phrase)){
                filteredContacts.add(c);
            }
        }
        return filteredContacts;
        //String query = "FROM Contact WHERE first_name or last_name like :inputPhrase AND user_id=:input_userId";
       /* Session session = HibernateUtil.openSession();
        return session.createQuery(query, Contact.class)
                .setParameter("inputPhrase", phrase)
                .setParameter("input_userId", user_id).list();*/
    }
}
