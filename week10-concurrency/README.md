# Week 10: Java Concurrency

A comprehensive Maven project demonstrating Java concurrency concepts including threads, synchronization, task decomposition, domain decomposition, and race conditions.

## 📚 Concepts Covered

Based on CS18000 Week 10 lecture materials, this project demonstrates:

### 1. **Basic Thread Concepts**
- Thread creation and lifecycle
- Thread states (New, Runnable, Not Runnable, Terminated)
- Thread methods: `start()`, `run()`, `join()`, `sleep()`, `yield()`
- Sequential vs Concurrent execution

### 2. **Task Decomposition**
- Splitting work into different tasks running on different threads
- Each task runs different code
- Example: Game simulation with separate Model and View threads
- Primary benefit: Responsiveness

### 3. **Domain Decomposition**
- Dividing data into subdomains
- Each thread runs the same code on different data
- Example: Matrix multiplication split across threads
- Primary benefit: Raw speed/performance

### 4. **Thread Synchronization**
- Using `join()` to wait for thread completion
- Coordinating multiple threads
- Example: Searching across multiple file servers

### 5. **Race Conditions**
- Understanding what race conditions are
- Why they occur (thread interleaving)
- How to fix them using `synchronized` blocks
- Real-world banking example

## 🏗️ Project Structure

```
week10-concurrency/
├── pom.xml
├── README.md
└── src/main/java/com/cs180/concurrency/
    ├── Main.java                          # Interactive menu to run all examples
    ├── basic/
    │   ├── MainThread.java                # Basic thread operations
    │   ├── MyTask.java                    # Creating threads with Runnable
    │   └── Interleave.java                # Thread execution interleaving
    ├── taskdecomposition/
    │   └── GameSimulation.java            # Model/View pattern with threads
    ├── domaindecomposition/
    │   └── MatrixMultiplication.java      # Parallel matrix computation
    ├── synchronization/
    │   └── FileSearchDemo.java            # Using join() for coordination
    └── racecondition/
        ├── RaceCondition.java             # Demonstrates the problem
        ├── NoRaceCondition.java           # Shows the solution
        └── BankAccountRace.java           # Real-world example
```

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Building the Project

```bash
cd week10-concurrency
mvn clean compile
```

### Running the Examples

#### Interactive Menu (Recommended)
```bash
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.Main"
```

This provides an interactive menu where you can:
- Run individual examples
- Run all examples sequentially
- See detailed output for each demonstration

#### Running Individual Examples

```bash
# Basic Thread Examples
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.basic.MainThread"
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.basic.MyTask"
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.basic.Interleave"

# Task Decomposition
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.taskdecomposition.GameSimulation"

# Domain Decomposition
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.domaindecomposition.MatrixMultiplication"

# Synchronization
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.synchronization.FileSearchDemo"

# Race Conditions
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.racecondition.RaceCondition"
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.racecondition.NoRaceCondition"
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.racecondition.BankAccountRace"
```

## 📖 Example Descriptions

### 1. MainThread
Demonstrates basic thread operations:
- Getting the current thread
- Thread.sleep() - pausing execution
- Thread.yield() - giving up CPU time

### 2. MyTask
Shows how to create threads using the Runnable interface (recommended approach).

### 3. Interleave
Visualizes how two threads executing simultaneously will interleave their operations, showing the unpredictability of concurrent execution.

### 4. GameSimulation (Task Decomposition)
Simulates a game with two separate threads:
- **Model thread**: Updates game state (character positions)
- **View thread**: Renders the current state

This demonstrates how task decomposition keeps UIs responsive even during heavy computation.

### 5. MatrixMultiplication (Domain Decomposition)
Multiplies two matrices using multiple threads, where each thread computes a portion of the result matrix. Shows how domain decomposition speeds up computation.

### 6. FileSearchDemo
Demonstrates thread synchronization using `join()`:
- Multiple threads search different file servers
- Main thread waits for all searches to complete
- Early termination when target is found

### 7. RaceCondition (UNSAFE)
Shows what happens when multiple threads modify shared data without synchronization:
- Two threads each increment a counter 10,000 times
- Expected result: 20,000
- Actual result: Often less due to lost updates
- Run multiple trials to see inconsistent results

### 8. NoRaceCondition (SAFE)
Fixes the race condition using `synchronized` blocks:
- Same scenario as above
- Uses synchronization to protect the critical section
- Result is always correct: 20,000

### 9. BankAccountRace
Real-world banking example showing:
- **Unsafe version**: Money can be lost due to race conditions
- **Safe version**: Synchronization ensures all deposits are recorded
- Demonstrates why thread safety is critical in financial applications

## 🔑 Key Concepts Explained

### Thread States
```
New Thread → start() → Runnable ⇄ Not Runnable → Terminated
                         ↺              ↑
                    yield()      sleep()/wait()
```

### Creating Threads
```java
// Recommended: Implement Runnable
public class MyTask implements Runnable {
    public void run() {
        // Thread code here
    }
}

Thread t = new Thread(new MyTask());
t.start();  // Don't call run() directly!
```

### Synchronization
```java
private static Object lock = new Object();

synchronized (lock) {
    // Only one thread can execute this block at a time
    // Critical section - modifying shared data
}
```

### Thread Coordination
```java
Thread t1 = new Thread(task1);
Thread t2 = new Thread(task2);

t1.start();
t2.start();

t1.join();  // Wait for t1 to finish
t2.join();  // Wait for t2 to finish

// Both threads are now complete
```

## 🎯 Learning Objectives

After exploring these examples, you should understand:

1. ✅ How to create and start threads in Java
2. ✅ The difference between task and domain decomposition
3. ✅ Why race conditions occur and how to prevent them
4. ✅ How to use `synchronized` blocks for thread safety
5. ✅ How to coordinate multiple threads using `join()`
6. ✅ When and why to use concurrent programming
7. ✅ The trade-offs between performance and complexity

## 🔍 Common Issues and Solutions

### Race Condition Symptoms
- Inconsistent results across runs
- Final values less than expected
- "Lost updates" in shared data

### Solution: Synchronization
```java
// WRONG - Race condition
counter++;

// RIGHT - Thread-safe
synchronized (lock) {
    counter++;
}
```

### Performance Considerations
- Synchronization adds overhead
- Too much synchronization reduces concurrency benefits
- Balance between safety and performance

## 📝 Additional Resources

- [Java Thread Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/Thread.html)
- [Java Concurrency Tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- Week 10 Lecture Slides: `week10.pdf`

## 🤔 Exercises

Try these on your own:

1. **Modify MatrixMultiplication** to use 4 threads instead of 2
2. **Create a new example** that searches for prime numbers using domain decomposition
3. **Experiment with RaceCondition** - what happens with more threads or more iterations?
4. **Add synchronization** to protect different variables in the same class
5. **Implement a producer-consumer** pattern using threads

## 📊 Expected Output Examples

### Race Condition (Unsafe)
```
Trial 1: counter = 18453 (expected 20000)
Trial 2: counter = 19127 (expected 20000)
Trial 3: counter = 17892 (expected 20000)
```

### No Race Condition (Safe)
```
Trial 1: counter = 20000 (expected 20000)
Trial 2: counter = 20000 (expected 20000)
Trial 3: counter = 20000 (expected 20000)
```

## 🛠️ Troubleshooting

### "Inconsistent results"
This is expected for RaceCondition examples - it demonstrates the problem!

### "Program hangs"
Check for:
- Missing `start()` calls
- Deadlocks (circular waiting)
- Infinite loops in thread code

### "IllegalThreadStateException"
You can only call `start()` once per thread. Create a new thread object if you need to run again.

## 📄 License

This project is created for educational purposes as part of CS18000 coursework.

---

**Author**: Generated for CS18000 Week 10
**Date**: November 2024
**Topic**: Java Concurrency and Synchronization
