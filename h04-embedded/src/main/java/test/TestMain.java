package test;

import domain.Contact;
import domain.Person;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestMain {

    private static Session session = HibernateUtil.getSessionFactory().openSession();
    private static Transaction transaction = session.getTransaction();

    public static void main(String[] args) {

        Person person = new Person();
        person.setName("Alpaslan");
        person.setLastName("Asker");
        person.setContact(new Contact("055555555","falan@filan.com"));


        transaction.begin();

        session.persist(person);

        transaction.commit();



        HibernateUtil.closeSession();
    }
}
