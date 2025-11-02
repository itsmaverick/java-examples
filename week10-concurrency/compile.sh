#!/bin/bash

# Simple compilation script for manual testing
# For production use, use Maven: mvn clean compile

# Create output directory
mkdir -p target/classes

# Compile all Java files
find src/main/java -name "*.java" -print0 | \
  xargs -0 javac -d target/classes -sourcepath src/main/java

echo "Compilation complete!"
echo "To run the Main class:"
echo "  java -cp target/classes com.cs180.concurrency.Main"
