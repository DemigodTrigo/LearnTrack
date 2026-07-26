# 📚 LearnTrack - Student & Course Management System

LearnTrack is a **console-based Student & Course Management System** developed using **Core Java**. It allows administrators to manage students, courses, and enrollments through a menu-driven console application.

This project was built as part of the **Airtribe Core Java Cohort** to practice Java fundamentals, Object-Oriented Programming (OOP), Collections, Exception Handling, and clean code principles.

---

## 🚀 Features

### 👨‍🎓 Student Management

- Add Student
- View All Students
- Search Student by ID
- Update Student Details
- Deactivate Student

### 📖 Course Management

- Add Course
- View All Courses
- Search Course by ID
- Update Course Details
- Activate Course
- Deactivate Course

### 📝 Enrollment Management

- Enroll Student into Course
- View All Enrollments
- View Enrollments by Student
- Mark Enrollment as Completed
- Cancel Enrollment

---

# 🛠 Technologies Used

- Java
- IntelliJ IDEA
- Core Java
- Object-Oriented Programming (OOP)
- Collections (ArrayList)
- Exception Handling
- Git & GitHub

---

# 📂 Project Structure

```text
LearnTrack
│
├── docs
│   ├── Setup_Instructions.md
│   ├── JVM_Basics.md
│   └── Design_Notes.md
│
└── src
    └── com
        └── airtribe
            └── learntrack
                │
                ├── Main.java
                │
                ├── entity
                │   ├── Person.java
                │   ├── Student.java
                │   ├── Course.java
                │   └── Enrollment.java
                │
                ├── repository
                │   ├── StudentRepository.java
                │   ├── CourseRepository.java
                │   └── EnrollmentRepository.java
                │
                ├── service
                │   ├── StudentService.java
                │   ├── CourseService.java
                │   └── EnrollmentService.java
                │
                ├── util
                │   ├── IdGenerator.java
                │   └── InputValidator.java
                │
                ├── exception
                │   ├── EntityNotFoundException.java
                │   └── InvalidInputException.java
                │
                ├── enums
                │   └── EnrollmentStatus.java
                │
                └── constants
                    ├── AppConstants.java
                    └── MenuOptions.java
```

---

# 🏗 Architecture

```text
                User
                  │
                  ▼
          Console Menu (Main)
                  │
                  ▼
            Service Layer
                  │
                  ▼
          Repository Layer
                  │
                  ▼
             Entity Classes
```

---

# 💡 Java Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Inheritance
- Method Overriding
- Runtime Polymorphism
- Constructor Overloading
- Static Members
- Collections (ArrayList)
- Exception Handling
- Custom Exceptions
- Enums
- Layered Architecture

---

# ▶️ How to Run

### Clone the repository

```bash
git clone https://github.com/DemigodTrigo/LearnTrack.git
```

### Open the project

Open the project in IntelliJ IDEA.

### Configure JDK

Make sure Java JDK (17/21 or your installed version) is configured.

### Run

Run the following file:

```text
Main.java
```

---

# 📸 Sample Output

```text
========== LearnTrack ==========

1. Student Management
2. Course Management
3. Enrollment Management
4. Exit

Enter your choice: 1


========== Student Menu ==========
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Deactivate Student
6. Back
Enter Choice : 1
First Name : Vishal
Last Name : Verma
Email : vishal.aws.delhi@gmail.com
Batch : Java Backend
Student Added Successfully.

```

---

# 📖 Documentation

Additional documentation is available in the **docs** folder.

- Setup Instructions
- JVM Basics
- Design Notes

---

# 📊 Class Diagram

> Add the UML Class Diagram image here.

Example:

```
Person
   ▲
   │
Student

Course

Enrollment

StudentRepository
CourseRepository
EnrollmentRepository

StudentService
CourseService
EnrollmentService
```

---

# 🎯 Learning Outcomes

Through this project, I gained hands-on experience with:

- Core Java programming
- Object-Oriented Programming principles
- Layered application design
- Exception handling
- Collections Framework
- Writing clean and modular code
- Git and GitHub workflow

---

# 👨‍💻 Author

**Vishal Verma**

GitHub: https://github.com/DemigodTrigo

---

## ⭐ If you found this project useful, consider giving it a star.