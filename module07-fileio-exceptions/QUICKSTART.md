# Quick Start Guide

## Opening in VS Code

1. Open VS Code
2. Click **File** → **Open Folder**
3. Navigate to: `/Users/sada/work/module07-fileio-exceptions`
4. Click **Open**

## Running the Application

### Option 1: Using VS Code (Recommended)

1. Open `src/main/java/com/cs18000/module07/FileIODemo.java`
2. Look for the "Run" button above the `main` method
3. Click **Run** or **Debug**

### Option 2: Using Terminal in VS Code

1. Open Terminal in VS Code: **View** → **Terminal**
2. Compile the project:
   ```bash
   ./compile.sh
   ```
3. Run the application:
   ```bash
   ./run.sh
   ```

### Option 3: Using Maven (if installed)

```bash
mvn compile
mvn exec:java
```

## What You'll See

The application presents an interactive menu with the following options:

1. **Low-Level I/O** - Demonstrates byte-oriented file operations
2. **High-Level I/O** - Shows primitive type I/O (int, double, boolean, String)
3. **Object I/O** - Demonstrates object serialization
4. **Text I/O** - Shows text file reading and writing
5. **Exception Handling** - Comprehensive exception handling examples
6. **Run All Demonstrations** - Runs all demos in sequence
7. **Exit** - Closes the application

## Concepts Covered

### File I/O
- ✓ Low-level byte I/O (`FileInputStream`/`FileOutputStream`)
- ✓ High-level primitive I/O (`DataInputStream`/`DataOutputStream`)
- ✓ Object serialization (`ObjectInputStream`/`ObjectOutputStream`)
- ✓ Text file I/O (`PrintWriter`/`BufferedReader`)
- ✓ Buffering and file closing
- ✓ Append mode

### Exception Handling
- ✓ Try-catch blocks
- ✓ Multiple catch blocks
- ✓ Finally clause
- ✓ Try-with-resources
- ✓ Custom exceptions
- ✓ Throws clause
- ✓ Checked vs. unchecked exceptions

## Project Structure

```
module07-fileio-exceptions/
├── src/main/java/com/cs18000/module07/
│   ├── FileIODemo.java                    ← Main application (start here!)
│   ├── LowLevelIO.java                    ← Byte-level I/O demos
│   ├── HighLevelIO.java                   ← Primitive type I/O demos
│   ├── ObjectIO.java                      ← Object serialization demos
│   ├── Tree.java                          ← Example serializable class
│   ├── TextIO.java                        ← Text file I/O demos
│   ├── ExceptionHandlingExamples.java     ← Exception handling demos
│   └── StudentNotFoundException.java      ← Custom exception class
├── pom.xml                                 ← Maven configuration
├── README.md                               ← Full documentation
└── QUICKSTART.md                           ← This file
```

## Tips for Learning

1. **Start with the menu** - Try each demonstration individually
2. **Read the code** - Each class is well-commented
3. **Experiment** - Try modifying the examples
4. **Check the output** - Pay attention to what gets printed
5. **Run all demos** - Option 6 runs everything in sequence

## Troubleshooting

### "Command not found: mvn"
- Maven is not installed or not in PATH
- Use `./compile.sh` and `./run.sh` instead

### Compilation errors
- Make sure Java 11+ is installed
- Run `java -version` to check

### VS Code doesn't recognize Java
- Install the "Extension Pack for Java" from the Extensions marketplace

## Next Steps

After exploring the demonstrations:
1. Read the full `README.md` for detailed explanations
2. Examine each Java file to understand the implementation
3. Try creating your own examples based on the patterns shown

---

**Happy Learning!** 🎓
