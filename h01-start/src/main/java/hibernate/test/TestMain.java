package hibernate.test;

import hibernate.HibernateUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestMain {
    private static final Logger LOGGER = LogManager.getLogger(TestMain.class);

    public static void main(String[] args) {
        LOGGER.debug("TEST Connection START...");
        testConnection();
        LOGGER.debug("TEST Connection STOP.");
    }

    private static void testConnection() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
        HibernateUtil.getSessionFactory().close();//uygulama sunucusu kapatılırsa !!
    }
}
