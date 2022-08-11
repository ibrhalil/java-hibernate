package test;

import entity.Person;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {
    public static void main(String[] args) {


        Person person = new Person();
        person.setId(10L);
        person.setName("Ali");
        person.setLastName("Veli");
        person.setAge(49);
        person.setBirthday(createBirthday("31-08-1982"));
        person.setAbout("falan filan falan filan falan filan falan filan falan filan ");
        person.setSalary(10000L);

        save(person);

        Person newPerson = getPersonById(10L);
        System.out.println(newPerson.toString());


    }

    private static void save (Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.persist(person);

        transaction.commit();
        session.close();
    }

    private static Person getPersonById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
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
