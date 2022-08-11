package test;

import entity.Person;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestMain {
    public static void main(String[] args) {

        Person person = new Person();
        person.setId(10L);
        person.setName("Ali");
        person.setLastName("Veli");
        person.setAge(49);

        save(person);

    }

    private static void save (Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.persist(person);

        transaction.commit();
        session.close();
    }
}
