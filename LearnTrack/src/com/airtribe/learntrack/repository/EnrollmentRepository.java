package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    private final List<Enrollment> enrollments;

    public EnrollmentRepository() {
        this.enrollments = new ArrayList<>();
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }

    public Enrollment findEnrollmentById(int id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null;
    }

    public boolean removeEnrollment(Enrollment enrollment) {
        return enrollments.remove(enrollment);
    }

}
