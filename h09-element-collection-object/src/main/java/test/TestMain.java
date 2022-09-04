package test;

import entity.Address;
import entity.Person;
import hibernate.HibernateUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestMain {
    private static final Logger LOGGER = LogManager.getLogger(TestMain.class);
    private static Session session = HibernateUtil.getSessionFactory().openSession();
    private static Transaction transaction = session.getTransaction();

    public static void main(String[] args) {


        Person person = new Person();
        person.setName("halil");
        person.setLastName("Aydn");
        person.setAddresses(Arrays.asList(
                new Address("istanbul","türkiye","340000","falan filan ..."),
                new Address("ankara","türkiye","060000","deneme deneme...")
        ).stream().collect(Collectors.toSet()));

        transaction.begin();

        session.persist(person);

        transaction.commit();

        Person newPerson = session.get(Person.class,1L);
        LOGGER.debug(newPerson);

        HibernateUtil.closeSession();
    }
}
