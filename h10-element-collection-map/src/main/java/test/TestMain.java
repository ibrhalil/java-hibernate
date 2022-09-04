package test;

import entity.Address;
import entity.AddressType;
import entity.Person;
import hibernate.HibernateUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestMain {
    private static final Logger LOGGER = LogManager.getLogger(TestMain.class);
    private static Session session = HibernateUtil.getSessionFactory().openSession();
    private static Transaction transaction = session.getTransaction();

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("halil");
        person.setLastName("Aydn");

        person.getAddresses().put(AddressType.HOME, new Address("istanbul","türkiye","340000","falan filan ..."));
        person.getAddresses().put(AddressType.OTHER, new Address("ankara","türkiye","060000","deneme deneme..."));

        person.getEmails().put("person","test@gmail.com");
        person.getEmails().put("work", "deneme@work.com.tr");

        transaction.begin();

        session.persist(person);

        transaction.commit();


        HibernateUtil.closeSession();
    }
}
