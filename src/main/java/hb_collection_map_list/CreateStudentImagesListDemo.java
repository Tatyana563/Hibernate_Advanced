package hb_collection_map_list;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class CreateStudentImagesListDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Student tempStudent = new Student("Mark", "Woe", "mark@gmail.com");
            List<String> theImages = tempStudent.getImages();

            theImages.add("photo1.jpg");
            theImages.add("photo2.jpg");
            theImages.add("photo3.jpg");
            theImages.add("photo3.jpg");

            session.beginTransaction();
            session.persist(tempStudent);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
