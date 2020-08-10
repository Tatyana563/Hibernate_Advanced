package hb_inheritance_tableperclass;

import hb_inheritance_singletable.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

public class Instructor extends MainUser {
    private double salary;

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
