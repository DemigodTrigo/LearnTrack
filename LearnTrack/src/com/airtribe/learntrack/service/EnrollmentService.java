package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(StudentRepository studentRepository,
                             CourseRepository courseRepository,
                             EnrollmentRepository enrollmentRepository) {

        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment enrollStudent(int studentId, int courseId) {

        Student student = studentRepository.findStudentById(studentId);

        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }

        Course course = courseRepository.findCourseById(courseId);

        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        if (!student.isActive()) {
            throw new IllegalArgumentException("Student is inactive.");
        }

        if (!course.isActive()) {
            throw new IllegalArgumentException("Course is inactive.");
        }

        Enrollment enrollment = new Enrollment(
                IdGenerator.getNextEnrollmentId(),
                studentId,
                courseId,
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        );

        enrollmentRepository.addEnrollment(enrollment);

        return enrollment;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.getAllEnrollments();
    }

    public Enrollment findEnrollmentById(int id) throws EntityNotFoundException {

        Enrollment enrollment = enrollmentRepository.findEnrollmentById(id);

        if (enrollment == null) {
            throw new EntityNotFoundException(
                    "Enrollment not found with ID: " + id);
        }

        return enrollment;
    }

    public void completeEnrollment(int enrollmentId) throws EntityNotFoundException {

        Enrollment enrollment = findEnrollmentById(enrollmentId);

        enrollment.setStatus(EnrollmentStatus.COMPLETED);
    }

    public void cancelEnrollment(int enrollmentId) throws EntityNotFoundException {

        Enrollment enrollment = findEnrollmentById(enrollmentId);

        enrollment.setStatus(EnrollmentStatus.CANCELLED);
    }

    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {

        List<Enrollment> result = new ArrayList<>();

        for (Enrollment enrollment : enrollmentRepository.getAllEnrollments()) {

            if (enrollment.getStudentId() == studentId) {
                result.add(enrollment);
            }

        }

        return result;
    }
}
