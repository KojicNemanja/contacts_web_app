package my.contacts.database.hibernate;

import my.contacts.database.DBConfiguration;
import my.contacts.database.DatabaseFileUtil;
import my.contacts.models.Contact;
import my.contacts.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    private static Session session = null;

    private static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            DBConfiguration dbConfiguration = DatabaseFileUtil.get();

            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            StringBuilder connection_url = new StringBuilder("jdbc:mysql://localhost:");
            connection_url.append(dbConfiguration.getHost());
            connection_url.append("/");
            connection_url.append(dbConfiguration.getDatabase());
            configuration.setProperty("hibernate.connection.url", connection_url.toString());
            configuration.setProperty("hibernate.connection.username", dbConfiguration.getUsername());
            String hashToPassword = dbConfiguration.getPassword().substring(32);
            configuration.setProperty("hibernate.connection.password", hashToPassword);
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.current_session_context_class", "thread");
            configuration.setProperty("hibernate.show_sql", "false");
            configuration.setProperty("hibernate.format_sql", "true");

            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Contact.class);

            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().
                            applySettings(configuration.getProperties());


            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }

    public static Session openSession(){
        if(session != null) return session;
        return getSessionFactory().openSession();
    }
}
