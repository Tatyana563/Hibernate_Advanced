package hb_inheritance_joinedtableperclass;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateInheritanceTablePerClassDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
           Student student = new Student("Jack", "Black", "jack@gmail.com", "Hibernate");
           Instructor instructor = new Instructor("Instructor", "master", "master@gmail.com", 100);
            session.beginTransaction();
            session.save(student);
            session.save(instructor);
            session.getTransaction().commit();
        } finally {
            session.close();
//            factory.close();
        }

        createQuery(factory);
        factory.close();
    }

    public static void createQuery(SessionFactory factory) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();

            List<SuperUser> users = session.createQuery("from SuperUser").list();
            List<SuperUser> users2 = session.createQuery("from SuperUser " +
                    "where course = 'Hibernate' or salary > 99")
                    .list();
            System.out.println(users);
            session.getTransaction().commit();
        } finally {
//            factory.close();
        }
    }
}
