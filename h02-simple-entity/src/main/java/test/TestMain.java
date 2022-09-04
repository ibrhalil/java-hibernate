package test;

import entity.Gender;
import entity.Person;
import hibernate.HibernateUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {

    private static final Logger LOGGER = LogManager.getLogger(TestMain.class);
    private static Session session = HibernateUtil.getSessionFactory().openSession();

    public static void main(String[] args) {


        Person person = new Person();
        person.setName("Ali");
        person.setLastName("Veli");
        person.setAge(49);
        person.setGender(Gender.MALE);
        person.setBirthday(createBirthday("31-08-1982"));
        person.setAbout("falan filan falan filan falan filan falan filan falan filan ");
        person.setSalary(10000L);

        save(person);

        Person newPerson = getPersonById(1L);//tablo bastan olustugu icin ilk kayıt 1 dir
        LOGGER.debug(newPerson.toString());

        /*newPerson.setAbout("booooosss");
        newPerson.setName("Hakan");
        newPerson.setLastName("Kara");

        Person updatePerson =  update(newPerson);
        LOGGER.debug(updatePerson.toString());


        delete(updatePerson);
        Person deletePerson = getPersonById(10L);
        LOGGER.debug(deletePerson != null ? deletePerson.toString() : "null");*/




        HibernateUtil.closeSession();
    }

    private static void delete(Person updatePerson) {
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.delete(updatePerson);

        transaction.commit();
    }

    private static void save (Person person) {
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.persist(person);

        transaction.commit();
    }

    private static Person update(Person person) {
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Person newPerson = (Person) session.merge(person);

        transaction.commit();

        return newPerson;
    }

    private static Person getPersonById(Long id) {

        Person person = session.get(Person.class, id);
        return person;
    }

    private static Date createBirthday(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
