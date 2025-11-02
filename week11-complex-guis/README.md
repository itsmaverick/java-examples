# Week 11 - Complex GUIs in Java

This project demonstrates complex GUI concepts in Java Swing based on Week 11 lecture materials. It includes examples of various layout managers, event handling, custom graphics, and the Model-View-Controller (MVC) pattern.

## Project Structure

```
week11-complex-guis/
├── src/main/java/com/cs18000/complexguis/
│   ├── MainDemo.java              # Main launcher with menu
│   ├── basic/
│   │   └── EmptyFrame.java        # Basic JFrame example
│   ├── events/
│   │   ├── PushMeButton.java      # ActionListener implementation
│   │   └── AnonymousInnerClassDemo.java  # Anonymous inner classes
│   ├── layouts/
│   │   ├── BorderLayoutExample.java      # BorderLayout demo
│   │   ├── FlowLayoutExample.java        # FlowLayout demo
│   │   ├── GridLayoutExample.java        # GridLayout demo
│   │   └── SubPanelExample.java          # Sub-panels with borders
│   ├── graphics/
│   │   └── GraphicsDemo.java      # Graphics2D drawing
│   └── mvc/
│       ├── Model.java             # MVC Model
│       ├── View.java              # MVC View
│       └── MVCDemo.java           # MVC demonstration
├── pom.xml
└── README.md
```

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Building the Project

To compile the project:

```bash
cd java-examples/week11-complex-guis
mvn clean compile
```

## Running the Examples

### Option 1: Run Main Menu (Recommended)

Launch the main menu to access all examples:

```bash
mvn exec:java
```

This will open a window with buttons to launch each individual example.

### Option 2: Run Individual Examples

You can also run each example directly:

```bash
# Basic JFrame
mvn exec:java -Dexec.mainClass="com.cs18000.complexguis.basic.EmptyFrame"

# ActionListener demo
mvn exec:java -Dexec.mainClass="com.cs18000.complexguis.events.PushMeButton"

# Anonymous inner classes
mvn exec:java -Dexec.mainClass="com.cs18000.complexguis.events.AnonymousInnerClassDemo"

# BorderLayout
mvn exec:java -Dexec.mainClass="com.cs18000.complexguis.layouts.BorderLayoutExample"

# FlowLayout
mvn exec:java -Dexec.mainClass="com.cs18000.complexguis.layouts.FlowLayoutExample"

# GridLayout
mvn exec:java -Dexec.mainClass="com.cs18000.complexguis.layouts.GridLayoutExample"

# SubPanels with BorderFactory
mvn exec:java -Dexec.mainClass="com.cs18000.complexguis.layouts.SubPanelExample"

# Graphics2D drawing
mvn exec:java -Dexec.mainClass="com.cs18000.complexguis.graphics.GraphicsDemo"

# MVC Pattern
mvn exec:java -Dexec.mainClass="com.cs18000.complexguis.mvc.MVCDemo"
```

## Concepts Demonstrated

### 1. Basic Components (basic/)

- **EmptyFrame.java**: Demonstrates basic JFrame creation using `SwingUtilities.invokeLater()` to run GUI code on the Event Dispatch Thread (EDT)

### 2. Event Handling (events/)

- **PushMeButton.java**: Shows ActionListener interface implementation, handling button clicks with state changes
- **AnonymousInnerClassDemo.java**: Demonstrates three patterns for using anonymous inner classes as event handlers

### 3. Layout Managers (layouts/)

- **BorderLayoutExample.java**: Shows 5-region layout (CENTER, NORTH, SOUTH, EAST, WEST) - default for JFrame
- **FlowLayoutExample.java**: Components flow left-to-right, wrapping as needed - default for JPanel
- **GridLayoutExample.java**: Equal-sized cells in an m x n grid
- **SubPanelExample.java**: Hierarchical panels with BorderFactory visual borders

### 4. Custom Graphics (graphics/)

- **GraphicsDemo.java**: Extends JComponent, overrides `paintComponent()` to draw shapes, lines, and text using Graphics2D

### 5. Model-View-Controller (mvc/)

- **Model.java**: Stores application data (position and dimensions)
- **View.java**: Extends JComponent, renders based on Model data
- **MVCDemo.java**: Controller with buttons that modify Model and trigger View updates

## Key Java Swing Concepts

### Event Dispatch Thread (EDT)
All GUI operations must run on the EDT. Use `SwingUtilities.invokeLater()` to ensure thread safety:

```java
SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        createGUI();
    }
});
```

### Layout Managers
- **BorderLayout**: Divides space into 5 regions
- **FlowLayout**: Simple left-to-right flow (default for JPanel)
- **GridLayout**: Equal-sized grid cells

### Custom Drawing
Override `paintComponent()` to perform custom drawing:

```java
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.BLUE);
    g2.fillRect(x, y, width, height);
}
```

### MVC Pattern
- **Model**: Holds data
- **View**: Displays data from Model
- **Controller**: Updates Model based on user input

## Opening in Cursor IDE

To open this project in Cursor:

1. Open Cursor IDE
2. Select "File" > "Open Folder"
3. Navigate to `java-examples/week11-complex-guis`
4. Click "Open"

Cursor will recognize the Maven project structure and provide Java development features.

## References

This project is based on Week 11 lecture slides covering:
- Pages 12, 29-30: JFrame basics
- Pages 35-40: ActionListener
- Pages 46-47: Anonymous inner classes
- Pages 18-21: BorderLayout
- Pages 53-56: FlowLayout
- Pages 57-60: GridLayout
- Pages 63-69: Sub-panels and BorderFactory
- Pages 71-75: Graphics2D
- Pages 76-79: MVC Pattern

## License

Educational use for CS 18000 course materials.
