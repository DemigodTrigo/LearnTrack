package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private final List<Course> courses;

    public CourseRepository(){
    this.courses = new ArrayList<>();
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public List<Course> getAllCourses(){
        return courses;
    }

    public Course findCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public boolean removeCourse(Course course){
        return courses.remove(course);
    }
}
