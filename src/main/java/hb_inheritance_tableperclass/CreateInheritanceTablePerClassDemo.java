package hb_inheritance_tableperclass;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInheritanceTablePerClassDemo {
    public static void main(String[] args) {
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
            session.persist(student);
            session.persist(instructor);
            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }
    }
}
