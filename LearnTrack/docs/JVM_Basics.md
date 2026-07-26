# JVM Basics

## What is JDK?

When I first started learning Java, I thought JDK was just something we install before writing code. But it's actually much more than that.

JDK (Java Development Kit) is the complete package a developer needs to create Java applications. It contains tools like the Java compiler (`javac`), the Java Runtime Environment (JRE), and many other utilities used during development.

Simply put:

> If you want to **write and develop** Java programs, you need the JDK.

---

## What is JRE?

After writing Java code, we don't always need development tools. We only need something that can run the application.

That's where JRE (Java Runtime Environment) comes in.

The JRE provides everything required to run a Java program. It contains the JVM and all the necessary Java libraries.

Think of it like this:

- JDK = Kitchen (where food is prepared)
- JRE = Dining Table (where food is served)

As a developer, I need the kitchen. As a user, I only need the dining table.

---

## What is JVM?

The JVM (Java Virtual Machine) is the heart of Java.

When we write Java code, the computer doesn't understand it directly. Even after compiling, the output is not machine code—it becomes **bytecode**.

The JVM takes this bytecode and converts it into machine language that the operating system understands.

Besides running Java programs, the JVM also manages memory, performs garbage collection, and handles many internal tasks automatically.

In simple words:

> The JVM acts like a translator between Java code and the computer.

---

## What is Bytecode?

When we save a Java file, it has the `.java` extension.

For example:

```
Main.java
```

When we compile it using:

```bash
javac Main.java
```

Java creates another file:

```
Main.class
```

This `.class` file contains **bytecode**.

Bytecode is not machine language, and it's not regular Java code either. It's an intermediate language that the JVM understands.

The JVM reads this bytecode and converts it into machine code before execution.

---

## What does "Write Once, Run Anywhere" mean?

One of Java's biggest advantages is platform independence.

Suppose I write a Java program on Windows and compile it.

The output is a `.class` file (bytecode).

Now I can copy that same `.class` file to a Linux or macOS machine.

As long as that computer has a compatible JVM installed, the program will run without changing the source code.

That's why Java follows the principle:

> **Write Once, Run Anywhere (WORA)**

We write the code only once, and the JVM on each operating system takes care of running it.

---

## How Java Executes a Program

The complete flow looks like this:

```
Main.java
      │
      ▼
Java Compiler (javac)
      │
      ▼
Main.class (Bytecode)
      │
      ▼
JVM
      │
      ▼
Machine Code
      │
      ▼
Program Output
```

So whenever I run a Java program, it follows these steps:

1. I write the source code (`.java`).
2. The Java compiler converts it into bytecode (`.class`).
3. The JVM reads the bytecode.
4. The JVM converts it into machine code.
5. Finally, the operating system executes it and displays the output.