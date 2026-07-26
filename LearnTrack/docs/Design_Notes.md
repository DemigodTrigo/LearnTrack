# Design Notes

## Why did I use ArrayList instead of an Array?

Initially, I thought of using arrays, but I realized that arrays have a fixed size. In this project, I don't know in advance how many students, courses, or enrollments will be added.

`ArrayList` grows dynamically, so I can keep adding new objects without worrying about the size. It also provides useful methods like `add()`, `remove()`, `get()`, and `size()`, which made the implementation much easier.

Since this project stores data only in memory and doesn't use a database, `ArrayList` was the best choice.

---

## Why did I create a Repository layer?

I created separate repository classes because I wanted one place responsible for storing and retrieving data.

Instead of directly accessing an `ArrayList` from the `Main` class or the service classes, all data operations go through the repository.

For example:

- `StudentRepository` manages student data.
- `CourseRepository` manages course data.
- `EnrollmentRepository` manages enrollment data.

This makes the project more organized and easier to maintain.

---

## Why did I create a Service layer?

The service layer contains the business logic of the application.

For example, when adding a student, the service:

- Validates the input.
- Generates a unique ID.
- Creates the Student object.
- Saves it using the repository.

Keeping business logic separate from data storage made the code cleaner and easier to understand.

---

## Why did I use Static members?

I used static members in the `IdGenerator` class.

The purpose was to generate unique IDs for students, courses, and enrollments.

Since static variables belong to the class instead of individual objects, every part of the application shares the same ID counter.

This ensures that IDs remain unique throughout the application.

---

## Why did I use Inheritance?

The `Student` class extends the `Person` class.

Both classes share common information such as:

- ID
- First Name
- Last Name
- Email

Instead of writing these fields again inside the `Student` class, I moved them to the `Person` class.

This reduced code duplication and made the code more reusable.

---

## Where did I use Method Overriding?

The `Student` class overrides the `getDisplayName()` method from the `Person` class.

The parent class returns the person's full name.

The child class customizes the output by including additional student information.

This helped me understand how runtime polymorphism works in Java.

---

## Why did I use Enums?

For enrollment status, I used an enum instead of storing plain strings.

The available values are:

- ACTIVE
- COMPLETED
- CANCELLED

Using an enum prevents invalid values such as spelling mistakes and makes the code more type-safe.

---

## Why did I create Utility classes?

I created utility classes to keep common functionality in one place.

For example:

- `IdGenerator` generates unique IDs.
- `InputValidator` validates user input such as email addresses and empty fields.

This avoids writing the same logic multiple times and keeps the code cleaner.

---

## Why did I create Custom Exceptions?

Instead of using generic exceptions everywhere, I created:

- `EntityNotFoundException`
- `InvalidInputException`

These exceptions make error messages more meaningful and clearly indicate what went wrong.

For example, if a student ID does not exist, the application throws an `EntityNotFoundException` instead of a generic exception.

---

## Overall Project Design

I followed a layered architecture to keep responsibilities separate.

```
User
   │
   ▼
Main (Console UI)
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

Each layer has its own responsibility:

- **Main** handles user interaction.
- **Service** contains business logic.
- **Repository** manages in-memory data storage.
- **Entity** represents the application's data.

This separation makes the project easier to read, maintain, and extend in the future.

---

## What I Learned

Building this project helped me understand many Core Java concepts in a practical way.

Some of the key concepts I practiced are:

- Object-Oriented Programming (OOP)
- Encapsulation
- Inheritance
- Polymorphism
- Constructor Overloading
- Collections (`ArrayList`)
- Static Members
- Exception Handling
- Enums
- Layered Architecture
- Clean Code Practices

Overall, this project gave me a better understanding of how different Java concepts work together to build a complete application.