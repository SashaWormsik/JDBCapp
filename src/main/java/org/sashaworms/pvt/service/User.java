package org.sashaworms.pvt.service;

import java.util.Date;

public class User {
    private Integer idUser;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private boolean male;
    private Department department;
    private Integer salary;

    public User(){

    }

    public User(Integer idUser, String firstMame, String lastName,
                Date birthdate, boolean male, Department department, Integer salary) {
        super();
        this.idUser = idUser;
        this.firstName = firstMame;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.male = male;
        this.department = department;
        this.salary = salary;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}

