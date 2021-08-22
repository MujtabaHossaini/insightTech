package com.mujtaba.poc.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private Date   birth_date;
    private String phone;
    private String email;
    private String department;

    public Employee() {
    }

    public Employee(String firstname, String lastname, Date birth_date, String phone, String email, String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
        this.department = department;
    }

    public Employee(int id, String firstname, String lastname, Date birth_date, String phone, String email, String department) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstname='" + firstname + "'")
                .add("lastname='" + lastname + "'")
                .add("birth_date=" + birth_date)
                .add("phone='" + phone + "'")
                .add("email='" + email + "'")
                .add("department='" + department + "'")
                .toString();
    }
}
