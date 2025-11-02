# Java Examples Collection

A collection of Java programming examples and demonstrations covering various CS18000 course topics.

## 📚 Modules

### [Module 07: File I/O and Exception Handling](./module07-fileio-exceptions)

Comprehensive demonstrations of File I/O and Exception Handling concepts including:
- Low-level byte I/O
- High-level primitive type I/O
- Object serialization
- Text file I/O
- Exception handling patterns
- Custom exceptions

**Quick Start:**
```bash
cd module07-fileio-exceptions
./compile.sh
./run.sh
```

See [module07-fileio-exceptions/README.md](./module07-fileio-exceptions/README.md) for detailed documentation.

---

## 🚀 Getting Started

Each module is self-contained with its own documentation, build scripts, and examples.

### Prerequisites
- Java 11 or higher
- Maven 3.6+ (optional, for Maven-based modules)

### Project Structure

```
java-examples/
├── README.md                           # This file
├── module07-fileio-exceptions/         # File I/O and Exception Handling
│   ├── README.md
│   ├── QUICKSTART.md
│   ├── pom.xml
│   ├── compile.sh
│   ├── run.sh
│   └── src/main/java/...
└── [future modules will be added here]
```

## 📖 Learning Path

1. **Module 07** - File I/O and Exception Handling
   - Learn file operations at different abstraction levels
   - Master exception handling patterns
   - Understand checked vs unchecked exceptions

*More modules coming soon!*

## 🔧 Development Setup

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

## 📝 Module Organization

Each module follows this structure:
- **README.md** - Comprehensive documentation
- **QUICKSTART.md** - Quick reference guide
- **pom.xml** - Maven configuration (if applicable)
- **compile.sh** - Compilation script
- **run.sh** - Execution script
- **src/** - Source code organized by package

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

## 🗺️ Roadmap

Planned modules:
- [ ] Module 08 - [To be added]
- [ ] Module 09 - [To be added]
- [ ] Module 10 - [To be added]

---

**Happy Learning!** 🎓
