#!/bin/bash

# Compile script for module07-fileio-exceptions

echo "Compiling Java source files..."

# Create output directory
mkdir -p target/classes

# Compile all Java files
javac -d target/classes \
    src/main/java/com/cs18000/module07/*.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo ""
    echo "To run the application:"
    echo "  java -cp target/classes com.cs18000.module07.FileIODemo"
else
    echo "Compilation failed!"
    exit 1
fi
