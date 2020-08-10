package hb_collection_map_map;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Entity

@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_2;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    @ElementCollection
    @CollectionTable(name = "image",joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id_2")})
    @MapKeyColumn(name = "file_name")
    @Column(name = "image_name")
    private Map<String, String> images = new HashMap<>();

    public int getId_2() {
        return id_2;
    }

    public void setId_2(int id_2) {
        this.id_2 = id_2;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getImages() {
        return images;
    }

    public void setImages(Map<String, String> images) {
        this.images = images;
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {
    }
}
