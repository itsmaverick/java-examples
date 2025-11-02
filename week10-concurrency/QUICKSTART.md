# Quick Start Guide

## Running the Examples

### Option 1: Using Maven (Recommended if Maven is installed)

```bash
cd week10-concurrency

# Compile the project
mvn clean compile

# Run the interactive menu
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.Main"

# Or run a specific example
mvn exec:java -Dexec.mainClass="com.cs180.concurrency.racecondition.RaceCondition"
```

### Option 2: Using the Compile Script (If Maven is not available)

```bash
cd week10-concurrency

# Compile all Java files
./compile.sh

# Run the interactive menu
java -cp target/classes com.cs180.concurrency.Main

# Or run a specific example
java -cp target/classes com.cs180.concurrency.racecondition.RaceCondition
```

### Option 3: Using your IDE (Cursor/IntelliJ/Eclipse)

1. Open the `week10-concurrency` folder in your IDE
2. Let the IDE import it as a Maven project
3. Run any of the `main()` methods directly from the IDE

## What to Try First

### 1. Start with the Interactive Menu
```bash
java -cp target/classes com.cs180.concurrency.Main
```

This gives you a menu to explore all examples.

### 2. See Race Conditions in Action
```bash
java -cp target/classes com.cs180.concurrency.racecondition.RaceCondition
java -cp target/classes com.cs180.concurrency.racecondition.NoRaceCondition
```

Compare the outputs to understand the problem and solution!

### 3. Banking Example (Most Relatable)
```bash
java -cp target/classes com.cs180.concurrency.racecondition.BankAccountRace
```

Shows a real-world scenario where race conditions can lose money!

## Project Structure
```
week10-concurrency/
├── src/main/java/com/cs180/concurrency/
│   ├── Main.java                    # Start here!
│   ├── basic/                       # Thread basics
│   ├── taskdecomposition/           # Game example
│   ├── domaindecomposition/         # Matrix example
│   ├── synchronization/             # join() example
│   └── racecondition/               # Race condition demos
├── pom.xml                          # Maven configuration
└── README.md                        # Full documentation
```

## Need Help?

- Read the full `README.md` for detailed explanations
- Check the comments in each Java file
- Refer to the `week10.pdf` lecture slides

## Common Commands

```bash
# Recompile after making changes
./compile.sh

# Run a quick test
java -cp target/classes com.cs180.concurrency.basic.MyTask

# View the source of an example
cat src/main/java/com/cs180/concurrency/racecondition/RaceCondition.java
```
