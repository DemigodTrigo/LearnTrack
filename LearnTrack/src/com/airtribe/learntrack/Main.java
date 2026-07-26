package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Person;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Shared repositories
        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

        // Services
        StudentService studentService =
                new StudentService(studentRepository);

        CourseService courseService =
                new CourseService(courseRepository);

        EnrollmentService enrollmentService =
                new EnrollmentService(
                        studentRepository,
                        courseRepository,
                        enrollmentRepository
                );


        boolean running = true;

        while (running) {

            System.out.println("\n=========================");
            System.out.println("      LearnTrack");
            System.out.println("=========================");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    studentMenu(scanner, studentService);
                    break;
                case 2:
                    courseMenu(scanner, courseService);
                    break;
                case 3:
                    enrollmentMenu(scanner, enrollmentService);

                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using LearnTrack!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        }
    }


    private static void studentMenu(Scanner scanner,
                                    StudentService studentService) {

        boolean back = false;

        while (!back) {

            System.out.println("\n========== Student Menu ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Deactivate Student");
            System.out.println("6. Back");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("First Name : ");
                        String firstName = scanner.nextLine();

                        System.out.print("Last Name : ");
                        String lastName = scanner.nextLine();

                        System.out.print("Email : ");
                        String email = scanner.nextLine();

                        System.out.print("Batch : ");
                        String batch = scanner.nextLine();

                        studentService.addStudent(firstName, lastName, email, batch);

                        System.out.println("Student Added Successfully.");
                        break;

                    case 2:

                        studentService.getAllStudents()
                                .forEach(System.out::println);

                        break;

                    case 3:

                        System.out.print("Enter Student ID : ");
                        int studentId = scanner.nextInt();

                        System.out.println(studentService.findStudentById(studentId));

                        break;

                    case 4:

                        System.out.print("Student ID : ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("First Name : ");
                        String fName = scanner.nextLine();

                        System.out.print("Last Name : ");
                        String lName = scanner.nextLine();

                        System.out.print("Email : ");
                        String mail = scanner.nextLine();

                        System.out.print("Batch : ");
                        String newBatch = scanner.nextLine();

                        studentService.updateStudent(
                                id,
                                fName,
                                lName,
                                mail,
                                newBatch
                        );

                        System.out.println("Student Updated Successfully.");

                        break;

                    case 5:

                        System.out.print("Student ID : ");
                        int deactivateId = scanner.nextInt();

                        studentService.deactivateStudent(deactivateId);

                        System.out.println("Student Deactivated Successfully.");

                        break;

                    case 6:

                        back = true;
                        break;

                    default:

                        System.out.println("Invalid Choice.");

                }

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

        }

    }

    private static void courseMenu(Scanner scanner,
                                   CourseService courseService) {

        boolean back = false;

        while (!back) {

            System.out.println("\n========== Course Menu ==========");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Update Course");
            System.out.println("5. Activate Course");
            System.out.println("6. Deactivate Course");
            System.out.println("7. Back");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Course Name : ");
                        String courseName = scanner.nextLine();

                        System.out.print("Description : ");
                        String description = scanner.nextLine();

                        System.out.print("Duration (Weeks): ");
                        int duration = scanner.nextInt();

                        courseService.addCourse(courseName, description, duration);

                        System.out.println("Course Added Successfully.");

                        break;

                    case 2:

                        courseService.getAllCourses()
                                .forEach(System.out::println);

                        break;

                    case 3:

                        System.out.print("Course ID : ");
                        int id = scanner.nextInt();

                        System.out.println(courseService.findCourseById(id));

                        break;

                    case 4:

                        System.out.print("Course ID : ");
                        int courseId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Course Name : ");
                        String name = scanner.nextLine();

                        System.out.print("Description : ");
                        String desc = scanner.nextLine();

                        System.out.print("Duration : ");
                        int weeks = scanner.nextInt();

                        courseService.updateCourse(courseId, name, desc, weeks);

                        System.out.println("Course Updated Successfully.");

                        break;

                    case 5:

                        System.out.print("Course ID : ");
                        int activeId = scanner.nextInt();

                        courseService.activateCourse(activeId);

                        System.out.println("Course Activated.");

                        break;

                    case 6:

                        System.out.print("Course ID : ");
                        int inactiveId = scanner.nextInt();

                        courseService.deactivateCourse(inactiveId);

                        System.out.println("Course Deactivated.");

                        break;

                    case 7:

                        back = true;
                        break;

                    default:

                        System.out.println("Invalid Choice.");

                }

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

        }

    }

    private static void enrollmentMenu(Scanner scanner,
                                       EnrollmentService enrollmentService) {

        boolean back = false;

        while (!back) {

            System.out.println("\n========== Enrollment Menu ==========");
            System.out.println("1. Enroll Student");
            System.out.println("2. View All Enrollments");
            System.out.println("3. View Student Enrollments");
            System.out.println("4. Complete Enrollment");
            System.out.println("5. Cancel Enrollment");
            System.out.println("6. Back");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Student ID : ");
                        int studentId = scanner.nextInt();

                        System.out.print("Course ID : ");
                        int courseId = scanner.nextInt();

                        enrollmentService.enrollStudent(studentId, courseId);

                        System.out.println("Enrollment Successful.");

                        break;

                    case 2:

                        enrollmentService.getAllEnrollments()
                                .forEach(System.out::println);

                        break;

                    case 3:

                        System.out.print("Student ID : ");
                        int id = scanner.nextInt();

                        enrollmentService.getEnrollmentsByStudentId(id)
                                .forEach(System.out::println);

                        break;

                    case 4:

                        System.out.print("Enrollment ID : ");
                        int completeId = scanner.nextInt();

                        enrollmentService.completeEnrollment(completeId);

                        System.out.println("Enrollment Completed.");

                        break;

                    case 5:

                        System.out.print("Enrollment ID : ");
                        int cancelId = scanner.nextInt();

                        enrollmentService.cancelEnrollment(cancelId);

                        System.out.println("Enrollment Cancelled.");

                        break;

                    case 6:

                        back = true;
                        break;

                    default:

                        System.out.println("Invalid Choice.");

                }

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

        }

    }
}


