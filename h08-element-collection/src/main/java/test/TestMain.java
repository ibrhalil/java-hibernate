package test;

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
        person.setPhoneNumbers(Arrays.asList("05555555555", "05500000000", "05400005555").stream().collect(Collectors.toList()));
        person.setEmails(Arrays.asList("falan@filan.com", "filan_2121@gmail.com", "test@mail.com").stream().collect(Collectors.toSet()));

        Person person2 = new Person();
        person2.setName("Murat");
        person2.setLastName("Dere");
        person2.setPhoneNumbers(Arrays.asList("05055055555").stream().collect(Collectors.toList()));
        person2.setEmails(Arrays.asList("murat@filan.com","test_murat@email.com").stream().collect(Collectors.toSet()));


        transaction.begin();

        session.persist(person);
        session.persist(person2);

        transaction.commit();

        Person newPerson = session.get(Person.class,1L);
        LOGGER.debug(newPerson);

        HibernateUtil.closeSession();
    }
}
