# Task27-Implement-a-Thread-Safe-Counter
java calculation

# Thread-Safe Counter in Java

## Project Description
This project demonstrates how multiple threads can update a shared counter in Java. It explains the difference between unsafe and thread-safe counter implementations using multithreading.

The project also demonstrates race conditions and compares the performance of different counter implementations.

## Objectives
- Understand multithreading in Java.
- Learn about race conditions.
- Understand thread synchronization.
- Implement thread-safe counters.
- Compare synchronized and AtomicInteger approaches.

## Technologies Used
- Java
- Multithreading
- synchronized keyword
- AtomicInteger
- Runnable Interface

## Features

### 1. Unsafe Counter
- Uses a normal integer variable.
- Multiple threads update the counter simultaneously.
- May produce incorrect results due to race conditions.

### 2. Synchronized Counter
- Uses the `synchronized` keyword.
- Allows only one thread at a time to update the counter.
- Prevents race conditions.

### 3. Atomic Counter
- Uses the `AtomicInteger` class.
- Provides thread-safe increment operations.
- Uses `incrementAndGet()` to update the counter safely.

### 4. Performance Comparison
- Runs multiple threads simultaneously.
- Measures execution time using `System.nanoTime()`.
- Compares the execution time of all three counters.

## Program Configuration
- Number of Threads: 8
- Increments Per Thread: 500,000
- Expected Final Count: 4,000,000

## How to Run the Project

**Step 1: Compile the Java program**

```bash
javac Task27.java
```

**Step 2: Run the program**

```bash
java Task27
```

## Sample Output

```text
THREAD-SAFE COUNTER DEMONSTRATION
----------------------------------
Unsafe Counter execution time: ...
Synchronized Counter execution time: ...
Atomic Counter execution time: ...

EXPECTED COUNT: 4000000

Unsafe Counter Result: (May be less than expected)
Synchronized Counter Result: 4000000
Atomic Counter Result: 4000000

DEMONSTRATION COMPLETED!
```

*Note: Execution times and the unsafe counter result may vary between runs.*

## Concepts Learned
- Multithreading
- Race Conditions
- Thread Synchronization
- synchronized Methods
- AtomicInteger
- Thread.join()
- Performance Measurement

## Interview Questions

**1. What is a race condition?**

A race condition occurs when multiple threads access and modify shared data simultaneously, which may lead to incorrect results.

**2. What does synchronized do?**

It allows only one thread at a time to execute a synchronized method on the same object.

**3. What is AtomicInteger?**

AtomicInteger is a class in Java that provides thread-safe operations on integer values.

**4. When should atomic classes be used?**

Atomic classes are useful when performing simple thread-safe operations such as incrementing or updating a shared variable.
