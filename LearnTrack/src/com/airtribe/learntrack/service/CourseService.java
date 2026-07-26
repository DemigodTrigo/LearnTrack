package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(String courseName,
                            String description,
                            int durationInWeeks) {

        if (InputValidator.isNullOrEmpty(courseName)) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }

        if (InputValidator.isNullOrEmpty(description)) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }

        if (!InputValidator.isPositiveNumber(durationInWeeks)) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }

        int courseId = IdGenerator.getNextCourseId();

        Course course = new Course(
                courseId,
                courseName,
                description,
                durationInWeeks,
                true
        );

        courseRepository.addCourse(course);

        return course;
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course findCourseById(int id) throws EntityNotFoundException {

        Course course = courseRepository.findCourseById(id);

        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }

        return course;
    }

    public void deactivateCourse(int id) throws EntityNotFoundException {

        Course course = findCourseById(id);

        course.setActive(false);
    }

    public void activateCourse(int id) throws EntityNotFoundException {

        Course course = findCourseById(id);

        course.setActive(true);
    }

    public void updateCourse(int id,
                             String courseName,
                             String description,
                             int durationInWeeks) throws EntityNotFoundException {

        Course course = findCourseById(id);

        if (!InputValidator.isNullOrEmpty(courseName)) {
            course.setCourseName(courseName);
        }

        if (!InputValidator.isNullOrEmpty(description)) {
            course.setDescription(description);
        }

        if (InputValidator.isPositiveNumber(durationInWeeks)) {
            course.setDurationInWeeks(durationInWeeks);
        }
    }
}
