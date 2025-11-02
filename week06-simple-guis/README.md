# Week 06 - Simple GUIs

CS18000: Problem Solving and Object-Oriented Programming

## Overview

This project demonstrates **Simple Graphical User Interfaces (GUIs)** in Java using the Swing library. It covers modal dialogs, user input, and file selection using `JOptionPane` and `JFileChooser`.

## Concepts Covered

### 1. JOptionPane Class

The `JOptionPane` class provides easy-to-use modal dialogs for interacting with users. Modal dialogs block program execution until the user responds, similar to using Scanner for keyboard input.

#### Message Types

JOptionPane supports five message types, each with a different icon:

- `PLAIN_MESSAGE` (-1) - No icon
- `ERROR_MESSAGE` (0) - Error icon
- `INFORMATION_MESSAGE` (1) - Information icon
- `WARNING_MESSAGE` (2) - Warning icon
- `QUESTION_MESSAGE` (3) - Question icon

#### Dialog Methods

**showMessageDialog**
- Simplest dialog for displaying information
- Returns `void` (do-only method)
- Example: `JOptionPane.showMessageDialog(null, "Hello World!");`

**showInputDialog**
- Prompts user for input
- Returns `String` with user input
- Supports free text input or dropdown selection
- Example: `String name = JOptionPane.showInputDialog("What is your name?");`

**showConfirmDialog**
- Asks user to confirm an action
- Returns `int` indicating button clicked
- Button options: YES_NO, YES_NO_CANCEL, OK_CANCEL
- Return values: YES_OPTION (0), NO_OPTION (1), CANCEL_OPTION (2), CLOSED_OPTION (-1)
- Example: `int result = JOptionPane.showConfirmDialog(null, "Continue?");`

**showOptionDialog**
- Most flexible dialog with custom buttons
- Returns index of button selected
- Allows custom button labels
- Example: Custom options array for multiple choices

### 2. JFileChooser Class

The `JFileChooser` class provides a standard file selection dialog.

Key features:
- Create with `new JFileChooser()`
- Set title with `setDialogTitle(String)`
- Show with `showOpenDialog(null)` or `showSaveDialog(null)`
- Returns `int`: `APPROVE_OPTION` (0) if file selected, `CANCEL_OPTION` (1) if cancelled
- Get selected file with `getSelectedFile()` which returns a `File` object

## Project Structure

```
week06-simple-guis/
├── pom.xml
├── README.md
└── src/main/java/com/cs180/gui/
    ├── GUIDemo.java            # Main menu application
    ├── JOptionPaneDemo.java    # JOptionPane demonstrations
    ├── JFileChooserDemo.java   # JFileChooser demonstrations
    └── CodonExtractor.java     # Practical example from PDF
```

## Classes

### GUIDemo

Main menu application that provides access to all demonstrations. Run this class to explore all the GUI concepts interactively.

**Features:**
- Welcome message
- Interactive menu
- Launches all demo modules
- Exit confirmation

### JOptionPaneDemo

Demonstrates all JOptionPane functionality:
- All five message types with their icons
- showMessageDialog with various configurations
- showInputDialog with text input and dropdown lists
- showConfirmDialog with different button combinations
- showOptionDialog with custom buttons

### JFileChooserDemo

Demonstrates file selection capabilities:
- Opening and selecting files
- Displaying file information (name, path, size, permissions)
- Reading and displaying file contents
- Save dialog functionality

### CodonExtractor

Practical application from the course material that:
- Reads DNA sequences from user input
- Validates DNA sequences (only A, C, G, T characters)
- Extracts and displays codons (3-character groups)
- Handles incomplete codons with asterisk notation
- Allows repeated operations until user exits

**Algorithm:**
1. Prompt user for DNA sequence
2. Convert to uppercase
3. Validate input (only ACGT characters)
4. Break into 3-character codons
5. Display results with line breaks
6. Mark incomplete codons with asterisks
7. Repeat until user chooses to exit

## Running the Project

### Prerequisites

- Java JDK 11 or higher
- Maven 3.6 or higher

### Build the Project

```bash
cd /Users/sada/work/java-examples/week06-simple-guis
mvn clean compile
```

### Run Individual Demos

**Main Menu (Recommended):**
```bash
mvn exec:java -Dexec.mainClass="com.cs180.gui.GUIDemo"
```

**JOptionPane Demo:**
```bash
mvn exec:java -Dexec.mainClass="com.cs180.gui.JOptionPaneDemo"
```

**JFileChooser Demo:**
```bash
mvn exec:java -Dexec.mainClass="com.cs180.gui.JFileChooserDemo"
```

**Codon Extractor:**
```bash
mvn exec:java -Dexec.mainClass="com.cs180.gui.CodonExtractor"
```

### Package as JAR

```bash
mvn package
java -jar target/week06-simple-guis-1.0-SNAPSHOT.jar
```

## Code Examples

### Simple Message Dialog

```java
JOptionPane.showMessageDialog(null, "Hello, World!");
```

### Input Dialog

```java
String name = JOptionPane.showInputDialog("What is your name?");
JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
```

### Confirm Dialog

```java
int result = JOptionPane.showConfirmDialog(null,
    "Do you want to continue?",
    "Confirmation",
    JOptionPane.YES_NO_OPTION);

if (result == JOptionPane.YES_OPTION) {
    System.out.println("User clicked Yes");
}
```

### File Chooser

```java
JFileChooser fc = new JFileChooser();
fc.setDialogTitle("Choose a File");
int returnValue = fc.showOpenDialog(null);

if (returnValue == JFileChooser.APPROVE_OPTION) {
    File file = fc.getSelectedFile();
    System.out.println("Selected: " + file.getAbsolutePath());
}
```

## Key Concepts from Week 06

### Text-Based vs GUI Interfaces

**Text-Based:**
- Program prompts for data
- User enters via keyboard
- Output in terminal window

**GUI:**
- Window displays controls/widgets
- User interacts with controls
- Program responds to events

### Dialog Concepts

- **Modal dialogs** - Application blocks waiting for user response
- **Look and Feel** - GUI components adapt to local system appearance
- **Event-driven** - Program responds to user actions

### Common Arguments

- `parentComponent` - Where dialog appears (null = center screen)
- `message` - Content displayed (String, icon, or HTML)
- `title` - Window heading text
- `messageType` - Icon and appearance style
- `optionType` - Default button configuration
- `options` - Custom button labels (array)
- `initialValue` - Default selection

## Learning Outcomes

After completing this module, you should understand:

1. How to create modal dialogs with JOptionPane
2. Different message types and their appropriate use cases
3. How to get user input through dialogs
4. How to present choices and get confirmation
5. How to use JFileChooser for file operations
6. The difference between text-based and GUI interfaces
7. How to structure a GUI application with multiple interactions

## Notes

- All GUI components require a window system (GUI environment) to run
- Dialogs are modal - they block execution until closed
- File objects describe the path to a file but don't contain the file's contents
- Always handle null returns (user cancelled) in input dialogs
- Use appropriate message types for better user experience

## References

- CS18000 Week 06 Lecture Materials
- Oracle Java Swing Documentation
- JOptionPane API Documentation
- JFileChooser API Documentation

## Author

CS18000 Course Materials - Week 06: Simple GUIs
