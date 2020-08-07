package hb_collction_map_sortedset;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetStudentImagesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session =factory.getCurrentSession();

        try{
            session.beginTransaction();
            int theId=1;
            Student student = session.get(Student.class, theId);
            System.out.println("Student's details: "+student);
            System.out.println("Images: "+student.getImages());
            session.getTransaction().commit();
        }
        finally{
            session.close();
            factory.close();
        }
    }
}
