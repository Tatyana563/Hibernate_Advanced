package hb_collection_map_sortedmap;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;


public class CreateStudentImagesSortedMapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
          Student tempStudent = new Student("Mark","Woe","mark@gmail.com");
       Map<String, String> theImages = tempStudent.getImages();

            theImages.put("image1","photo3.jpg");
            theImages.put("image2","photo2.jpg");
            theImages.put("image3","photo1.jpg");

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
