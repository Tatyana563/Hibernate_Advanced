package hb_inheritance_mappedsuperclass;

import javax.persistence.Entity;

@Entity

public class Instructor extends MainUser {
    private double salary;

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email, double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
