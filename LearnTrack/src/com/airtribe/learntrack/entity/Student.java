package com.airtribe.learntrack.entity;

public class Student extends Person {

    private String batch;
    private boolean active;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String email,
                   String batch, boolean active) {

        super(id, firstName, lastName, email);

        this.batch = batch;
        this.active = active;
    }

    public String getBatch() {
        return batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return getFirstName() + " " + getLastName() + " (" + batch + ")";
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getDisplayName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", active=" + active +
                '}';
    }

}
