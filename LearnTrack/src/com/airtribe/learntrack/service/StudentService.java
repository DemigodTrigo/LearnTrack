package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(
            String firstName,
            String lastName,
            String email,
            String batch) {

        if (InputValidator.isNullOrEmpty(firstName)) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }

        if (InputValidator.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }

        if (!InputValidator.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email.");
        }

        int studentId = IdGenerator.getNextStudentId();

        Student student = new Student(
                studentId,
                firstName,
                lastName,
                email,
                batch,
                true
        );

        studentRepository.addStudent(student);

        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student findStudentById(int id) throws EntityNotFoundException {

        Student student = studentRepository.findStudentById(id);

        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }

        return student;
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {

        Student student = findStudentById(id);

        student.setActive(false);
    }

    public void updateStudent(int id,
                              String firstName,
                              String lastName,
                              String email,
                              String batch) throws EntityNotFoundException {

        Student student = findStudentById(id);

        if (!InputValidator.isNullOrEmpty(firstName)) {
            student.setFirstName(firstName);
        }

        if (!InputValidator.isNullOrEmpty(lastName)) {
            student.setLastName(lastName);
        }

        if (InputValidator.isValidEmail(email)) {
            student.setEmail(email);
        }

        if (!InputValidator.isNullOrEmpty(batch)) {
            student.setBatch(batch);
        }
    }

}
