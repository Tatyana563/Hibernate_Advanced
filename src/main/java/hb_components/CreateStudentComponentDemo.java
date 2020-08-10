package hb_components;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentComponentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Address homeAddress = new Address("Main", "1234", "London");
            Address billingAddress = new Address("bMain", "b1234", "bLondon");
            Student student = new Student("Bob", "Green", "bob@gmail.com");
            student.setAddress(homeAddress);
            student.setBillingAddress(billingAddress);

            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
