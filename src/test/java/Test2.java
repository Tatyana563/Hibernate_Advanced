import hb_inheritance_tableperclass.Instructor;
import hb_inheritance_tableperclass.MainUser;
import hb_inheritance_tableperclass.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {

    @Test
    void check() {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Instructor.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();
            try {
                MainUser student = new Student("Jack", "Black", "jack@gmail.com", "Hibernate");
                MainUser instructor = new Instructor("Instructor", "master", "master@gmail.com", 100);
                session.beginTransaction();
                session.save(student);
                session.save(instructor);
                // session.getTransaction().commit();

                Boolean test = session.createQuery("select firstName from MainUser ").getResultList().isEmpty();

            } finally {
                session.close();
                factory.close();
            }
            assertEquals(session.createQuery("select firstName from MainUser ").getResultList().isEmpty(), false);
        }

}

