package test;

import domain.Student;
import hibernate.HibernateUtil;
import lombok.extern.java.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TestMain {
    private static final Logger LOGGER = LogManager.getLogger(TestMain.class);
    private static Session session = HibernateUtil.getSessionFactory().openSession();
    private static Transaction transaction = session.getTransaction();

    public static void main(String[] args) {

        /*
        Student student1 = new Student();
        student1.setNumber("1234");
        student1.setRecordedYear("2022");
        student1.setNameAndLastName("Ali Han");

        Student student2 = new Student();
        student2.setNumber("1235");
        student2.setRecordedYear("2022");
        student2.setNameAndLastName("Hasan Can");

        Student student3 = new Student();
        student3.setNumber("1235");
        student3.setRecordedYear("2021");
        student3.setNameAndLastName("Kazım Kara");

        Student student4 = new Student();
        student4.setNumber("1234");
        student4.setRecordedYear("2021");
        student4.setNameAndLastName("Murat Hasoğlu");

        transaction.begin();

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);
        session.persist(student4);

        transaction.commit();*/

        Student newStudent = session.find(Student.class, new Student("2022","1235",""));
        LOGGER.debug(newStudent);

        /*Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("number","1234"));
        criteria.add(Restrictions.eq("recordedYear","2021"));
        Student newStudent2 = (Student) criteria.uniqueResult();
        LOGGER.debug(newStudent2);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root).where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("number"),"1234"),
                        criteriaBuilder.equal(root.get("recordedYear"),"2022")
                )
        );
        Student newStudent3 = session.createQuery(query).uniqueResult();
        LOGGER.debug(newStudent3);*/


        HibernateUtil.closeSession();

    }
}
