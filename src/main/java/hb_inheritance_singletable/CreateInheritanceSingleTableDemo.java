package hb_inheritance_singletable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInheritanceSingleTableDemo {
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
            session.persist(student);
            session.persist(instructor);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
