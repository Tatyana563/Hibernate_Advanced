package hb_collection_map_map;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;


public class CreateStudentImagesMapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
          Student tempStudent = new Student("Mark","Woe","mark@gmail.com");
          Map<String, String> theImages = tempStudent.getImages();

            theImages.put("file1","photo1.jpg");
            theImages.put("file2","photo2.jpg");
            theImages.put("file3","photo3.jpg");

            session.beginTransaction();
            session.persist(tempStudent);
            session.getTransaction().commit();
        }
        finally{
            session.close();
            factory.close();
        }
    }
}
