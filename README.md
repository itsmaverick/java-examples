# Java Examples Collection

A comprehensive collection of Java programming examples and demonstrations covering CS18000 course topics including File I/O, GUIs, Concurrency, and Network Programming.

**GitHub Repository**: [https://github.com/itsmaverick/java-examples](https://github.com/itsmaverick/java-examples)

## 📑 Table of Contents

- [Projects Overview](#-projects-overview)
  - [Week 06: Simple GUIs](#week-06-simple-guis)
  - [Module 07: File I/O and Exception Handling](#module-07-file-io-and-exception-handling)
  - [Week 10: Java Concurrency](#week-10-java-concurrency)
  - [Week 11: Complex GUIs](#week-11-complex-guis)
  - [Network I/O Demo](#network-io-demo)
- [Getting Started](#-getting-started)
- [Learning Path](#-learning-path)
- [Quick Reference by Topic](#-quick-reference-by-topic)
- [Development Setup](#-development-setup)
- [Project Status](#-project-status)
- [Tips for Success](#-tips-for-success)
- [Troubleshooting](#-troubleshooting)

---

## 📚 Projects Overview

### [Week 06: Simple GUIs](./week06-simple-guis)

Introduction to graphical user interfaces using Java Swing with modal dialogs and file selection.

**Topics Covered:**
- `JOptionPane` - Message, input, confirm, and option dialogs
- `JFileChooser` - File selection and navigation
- Modal dialogs and user interaction
- DNA Codon Extractor application

**Quick Start:**
```bash
cd week06-simple-guis
mvn exec:java -Dexec.mainClass="com.cs180.gui.GUIDemo"
```

See [week06-simple-guis/README.md](./week06-simple-guis/README.md) for detailed documentation.

---

### [Module 07: File I/O and Exception Handling](./module07-fileio-exceptions)

Comprehensive demonstrations of File I/O operations and Exception Handling patterns.

**Topics Covered:**
- Low-level byte I/O (`FileInputStream`, `FileOutputStream`)
- High-level primitive type I/O (`DataInputStream`, `DataOutputStream`)
- Object serialization (`ObjectInputStream`, `ObjectOutputStream`)
- Text file I/O (`BufferedReader`, `PrintWriter`)
- Exception handling patterns (try-catch, try-with-resources)
- Custom exceptions

**Quick Start:**
```bash
cd module07-fileio-exceptions
mvn exec:java
```

See [module07-fileio-exceptions/README.md](./module07-fileio-exceptions/README.md) for detailed documentation.

---

### [Week 10: Java Concurrency](./week10-concurrency)

Demonstrates multi-threading, synchronization, and concurrent programming in Java.

**Topics Covered:**
- Thread creation and lifecycle
- Task decomposition vs Domain decomposition
- Thread synchronization with `join()`
- Race conditions and how to prevent them
- `synchronized` blocks for thread safety
- Real-world examples (game simulation, matrix multiplication, banking)

**Quick Start:**
```bash
cd week10-concurrency
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.Main"
```

See [week10-concurrency/README.md](./week10-concurrency/README.md) for detailed documentation.

---

### [Week 11: Complex GUIs](./week11-complex-guis)

Advanced GUI programming with Swing covering layout managers, event handling, custom graphics, and MVC pattern.

**Topics Covered:**
- JFrame and JPanel basics
- Event handling with `ActionListener` and anonymous inner classes
- Layout managers: `BorderLayout`, `FlowLayout`, `GridLayout`
- Sub-panels and `BorderFactory`
- Custom graphics with `Graphics2D` and `JComponent`
- Model-View-Controller (MVC) pattern

**Quick Start:**
```bash
cd week11-complex-guis
mvn exec:java
```

See [week11-complex-guis/README.md](./week11-complex-guis/README.md) for detailed documentation.

---

### [Network I/O Demo](./network-io-demo)

Client-server programming with sockets and network communication.

**Topics Covered:**
- Client-Server architecture
- Sockets and TCP/IP communication
- Object serialization over networks
- Multi-threaded server design
- ObjectStream initialization order (critical for avoiding deadlock)
- Text-based protocols with `Scanner` and `PrintWriter`

**Quick Start:**
```bash
# Terminal 1 - Start server
cd network-io-demo
mvn exec:java -Dexec.mainClass="com.example.network.EchoServer"

# Terminal 2 - Start client
mvn exec:java -Dexec.mainClass="com.example.network.EchoClient"
```

See [network-io-demo/README.md](./network-io-demo/README.md) for detailed documentation.

---

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/itsmaverick/java-examples.git
cd java-examples
```

Each module is self-contained with its own documentation, build scripts, and examples.

### Prerequisites
- Java 11 or higher
- Maven 3.6+ (optional, for Maven-based modules)

### Project Structure

```
java-examples/
├── README.md                           # This file
├── CURSOR_SETUP.md                     # Cursor IDE installation guide
├── CURSOR_QUICKREF.md                  # Cursor shortcuts and tips
├── .cursorrules                        # AI assistance configuration
│
├── week06-simple-guis/                 # Week 06: Simple GUIs
│   ├── README.md
│   ├── pom.xml
│   └── src/main/java/com/cs180/gui/
│       ├── GUIDemo.java                # Main menu
│       ├── JOptionPaneDemo.java
│       ├── JFileChooserDemo.java
│       └── CodonExtractor.java
│
├── module07-fileio-exceptions/         # Module 07: File I/O & Exceptions
│   ├── README.md
│   ├── QUICKSTART.md
│   ├── pom.xml
│   ├── compile.sh
│   ├── run.sh
│   └── src/main/java/com/cs18000/module07/
│
├── week10-concurrency/                 # Week 10: Concurrency
│   ├── README.md
│   ├── pom.xml
│   └── src/main/java/com/cs180/concurrency/
│       ├── Main.java                   # Interactive menu
│       ├── basic/                      # Thread basics
│       ├── taskdecomposition/          # Task decomposition
│       ├── domaindecomposition/        # Domain decomposition
│       ├── synchronization/            # Thread coordination
│       └── racecondition/              # Race conditions
│
├── week11-complex-guis/                # Week 11: Complex GUIs
│   ├── README.md
│   ├── pom.xml
│   └── src/main/java/com/cs18000/complexguis/
│       ├── MainDemo.java               # Main launcher
│       ├── basic/                      # JFrame basics
│       ├── events/                     # Event handling
│       ├── layouts/                    # Layout managers
│       ├── graphics/                   # Graphics2D
│       └── mvc/                        # MVC pattern
│
└── network-io-demo/                    # Network I/O
    ├── README.md
    ├── pom.xml
    └── src/main/java/com/example/network/
        ├── Message.java
        ├── BasicServer.java
        ├── BasicClient.java
        ├── EchoServer.java
        └── EchoClient.java
```

## 📖 Learning Path

We recommend following this order for a progressive learning experience:

### 1. **Week 06: Simple GUIs**
Start with basic GUI programming to make your applications interactive.
- Learn modal dialogs with `JOptionPane`
- File selection with `JFileChooser`
- Build simple interactive applications
- **Skills**: User input, file selection, basic GUI concepts

### 2. **Module 07: File I/O and Exception Handling**
Master reading/writing data and handling errors gracefully.
- Low-level, high-level, and object I/O
- Text file operations
- Exception handling patterns
- Try-with-resources
- **Skills**: Data persistence, error handling, file operations

### 3. **Week 10: Java Concurrency**
Learn to write programs that do multiple things simultaneously.
- Thread creation and management
- Task and domain decomposition
- Avoiding race conditions
- Thread synchronization
- **Skills**: Parallel programming, thread safety, performance optimization

### 4. **Week 11: Complex GUIs**
Build sophisticated graphical interfaces with custom components.
- Layout managers and event handling
- Anonymous inner classes
- Custom graphics with Graphics2D
- MVC architectural pattern
- **Skills**: Advanced GUI design, event-driven programming, software architecture

### 5. **Network I/O**
Connect applications across networks with client-server architecture.
- Socket programming
- Client-server communication
- Object serialization over networks
- Multi-threaded servers
- **Skills**: Network programming, distributed systems, protocol design

---

## 🎯 Quick Reference by Topic

### GUI Programming
- **Simple GUIs** → `week06-simple-guis/`
- **Complex GUIs** → `week11-complex-guis/`

### I/O Operations
- **File I/O** → `module07-fileio-exceptions/`
- **Network I/O** → `network-io-demo/`

### Advanced Topics
- **Concurrency** → `week10-concurrency/`
- **Exception Handling** → `module07-fileio-exceptions/`
- **Design Patterns (MVC)** → `week11-complex-guis/mvc/`

## 🔧 Development Setup

### Using Cursor IDE (Recommended with AI)

**New to Cursor?** See [CURSOR_SETUP.md](./CURSOR_SETUP.md) for installation and configuration.

1. Open Cursor IDE
2. **File** → **Open Folder** → Select `java-examples`
3. Trust the workspace when prompted
4. The `.cursorrules` file automatically configures AI assistance
5. Press **⌘L** (Mac) to chat with Claude about the code
6. See [CURSOR_QUICKREF.md](./CURSOR_QUICKREF.md) for shortcuts and tips

**AI Features:**
- **⌘L** - Chat with Claude about your code
- **⌘K** - Inline code editing with AI
- **⌘I** - Multi-file editing (Composer)
- **@Codebase** - Query the entire project

### Using VS Code

1. Open the root `java-examples` folder in VS Code
2. Navigate to any module
3. Each module has its own VS Code launch configuration

### Using Command Line

Each module includes shell scripts for easy compilation and execution:
```bash
cd [module-name]
./compile.sh    # Compile the module
./run.sh        # Run the demonstration
```

### Using Maven

For Maven-based modules:
```bash
cd [module-name]
mvn compile
mvn exec:java
```

## 📝 Project Organization

Each project follows a consistent structure:
- **README.md** - Comprehensive documentation with concept explanations
- **pom.xml** - Maven configuration for building and running
- **src/main/java/** - Source code organized by package
- **Main class** - Most projects have a main menu or demo launcher

Some projects also include:
- **QUICKSTART.md** - Quick reference guide (module07)
- **compile.sh / run.sh** - Compilation and execution scripts (module07)

## 🎯 Course Information

These examples are based on:
- **Course**: CS18000 - Problem Solving and Object-Oriented Programming
- **Institution**: Purdue University
- **Purpose**: Educational demonstrations and hands-on learning

## 🤝 Contributing

This is a personal learning repository. Feel free to fork and experiment!

## 📄 License

Educational use only. Code examples are provided as-is for learning purposes.

---

## 🗺️ Project Status

### ✅ Completed Projects

- [x] **Week 06** - Simple GUIs (JOptionPane, JFileChooser)
- [x] **Module 07** - File I/O and Exception Handling
- [x] **Week 10** - Java Concurrency and Synchronization
- [x] **Week 11** - Complex GUIs (Swing, Layout Managers, MVC)
- [x] **Network I/O** - Client-Server Programming

### 🔮 Potential Future Additions

- [ ] Data Structures (Lists, Maps, Sets)
- [ ] Generics and Collections
- [ ] Lambda Expressions and Streams
- [ ] Unit Testing with JUnit
- [ ] Database connectivity (JDBC)
- [ ] Design Patterns (beyond MVC)

## 💡 Tips for Success

1. **Start with the basics** - Follow the recommended learning path
2. **Run the examples** - Don't just read the code, execute it and observe
3. **Experiment** - Modify the code and see what happens
4. **Read the READMEs** - Each project has detailed explanations
5. **Use the interactive menus** - Most projects have launcher classes
6. **Leverage Cursor AI** - Press ⌘L to ask questions about the code

## 🆘 Troubleshooting

### Maven Issues
```bash
# Clean and rebuild
mvn clean compile

# If dependencies fail
mvn dependency:resolve
```

### Java Version Issues
```bash
# Check your Java version
java -version

# Should be Java 11 or higher
```

### GUI Not Showing
- Ensure you're running in a graphical environment
- Try running from terminal instead of background process
- Check for error messages in console output

---

**Happy Learning!** 🎓

*Maintained for CS18000 - Problem Solving and Object-Oriented Programming*
