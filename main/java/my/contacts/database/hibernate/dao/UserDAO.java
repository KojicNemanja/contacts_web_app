package my.contacts.database.hibernate.dao;

import my.contacts.database.hibernate.HibernateUtil;
import my.contacts.models.User;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class UserDAO {

    public static int save(User user){
        int generated_id = -1;
        Session session = HibernateUtil.openSession();
        try{
            session.getTransaction().begin();
            session.persist(user); //user_id mora biti 'null' da bi radila komanda 'session.persist()'
            session.getTransaction().commit();
            generated_id = user.getUser_id();
        }catch (Exception ex){
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return generated_id;
    }

    public static User getForUsername(String username){
        String query = "FROM User WHERE username = :input";
        Session session = HibernateUtil.openSession();
        User user = session.createQuery(query, User.class)
                .setParameter("input", username)
                .getSingleResult();
        return user;
    }
}
