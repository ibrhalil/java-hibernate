package test;

import entity.User;
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

        User user1 = new User();
        user1.setName("Ali");
        user1.setLastName("Veli");
        user1.setNickName("aliveli");
        user1.setPassword("1234");

        User user2 = new User();
        user2.setName("Hakan");
        user2.setLastName("Ağır");
        user2.setNickName("hakannn");
        user2.setPassword("4561");

        User user3 = new User();
        user3.setName("Ramazan");
        user3.setLastName("Taş");
        user3.setNickName("tas45");
        user3.setPassword("4545");

        User user4 = new User();
        user4.setName("Fatma");
        user4.setLastName("Gül");
        user4.setNickName("sucune");
        user4.setPassword("9999");

        transaction.begin();

        session.persist(user1);
        session.persist(user2);
        session.persist(user3);
        session.persist(user4);

        transaction.commit();


        HibernateUtil.closeSession();
    }
}
