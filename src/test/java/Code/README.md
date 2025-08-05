# Java Basics Practice

This repository contains a set of simple Java programs designed to practice fundamental programming concepts: 
conditional statements, loops, string manipulation, type conversion, and basic methods.

## Structure

All classes are located in the `Code` package. Below is a brief description of each file:

---

### `AgeIf.java`

This program asks the user for their age and categorizes them as:
- `0–17`: Child
- `18–59`: Adult
- `60+`: Senior  
  Entering `666` will terminate the program.

**Method:**
- `getAgeCategory(int age)` — returns the age category as a string.

---

### `ForLoop.java`

Prompts the user for a number and prints a pyramid of asterisks `*`, growing in height.

---

### `Loops.java`

Displays:
- Numbers from 1 to 10 (ascending)
- Numbers from 10 to 1 (descending)

Implemented using the `loop()` method.

---

### `MyMethod.java`

Demonstrates method invocation and variable tracking across multiple calls. The `step` variable increments each time the method is called.

---

### `NumberStr.java`

Shows:
- String to integer conversion
- Simple arithmetic with integers
- Integer to string conversion

---

### `Task1.java`

Includes two sub-tasks:
1. Compare the length of a string to a float number.
2. Calculate the average score from a list of 10 student subjects.

**Subjects example:**  
`List<String> subjects = List.of("Math - 10", "Physics - 10", ...)`

---

## Requirements

- Java 17+
- Any Java-compatible environment (e.g., IntelliJ IDEA, VS Code, or command line)

## How to Run

Compile and run the desired class:
```bash
javac Code/AgeIf.java
java Code.AgeIf
