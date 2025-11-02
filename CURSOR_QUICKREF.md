# Cursor Quick Reference for Java Examples

## 🚀 Essential Keyboard Shortcuts

| Action | Mac | Description |
|--------|-----|-------------|
| **AI Chat** | `⌘L` | Open Claude chat sidebar |
| **Inline Edit** | `⌘K` | Edit code inline with AI |
| **Composer** | `⌘I` | Multi-file AI editing |
| **Command Palette** | `⌘⇧P` | Access all commands |
| **Quick Open** | `⌘P` | Quick file navigation |
| **Terminal** | `⌃\`` | Toggle integrated terminal |
| **Search Files** | `⌘⇧F` | Search across all files |
| **Run File** | `F5` | Run current Java file |

## 💬 Using Claude AI

### Chat Commands (⌘L)

```
@Codebase - Query entire codebase
@File - Ask about current file
@Folder - Ask about specific folder
@Web - Search the web
```

**Examples:**
- `@Codebase explain how exceptions are handled`
- `@File what does this main method do?`
- `explain the difference between checked and unchecked exceptions`

### Inline Editing (⌘K)

1. Select code (or place cursor)
2. Press `⌘K`
3. Type your request
4. Review and accept suggestions

**Examples:**
- "add javadoc comments"
- "refactor this method to be more readable"
- "add error handling"
- "explain this code"

### Composer (⌘I)

For multi-file changes:
1. Press `⌘I`
2. Describe changes across files
3. Review all proposed changes
4. Accept or modify

**Example:**
```
Create a new module08 following the same structure
as module07 but for [new topic]
```

## 🎯 AI-Powered Features

### Code Completion
- Just start typing
- Cursor suggests completions
- Press `Tab` to accept
- Press `Esc` to dismiss

### Generate Code
1. Write a comment describing what you want
2. Cursor will suggest implementation
3. Example:
   ```java
   // Method to read a file line by line and print each line
   ```

### Explain Code
- Select code
- Press `⌘L`
- Type "explain this"
- Get detailed explanation

### Fix Errors
- Click on error in code
- Press `⌘.` for quick fixes
- Or ask Claude: "fix this error"

## 📁 Project Navigation

### File Structure
```
java-examples/
├── module07-fileio-exceptions/
│   └── src/main/java/com/cs18000/module07/
│       ├── FileIODemo.java          ← Main demo
│       ├── LowLevelIO.java
│       ├── HighLevelIO.java
│       └── ...
```

### Quick Navigation
- `⌘P` then type filename
- `⌘⇧O` for symbols in file
- `F12` go to definition
- `⌥F12` peek definition

## ▶️ Running Code

### Method 1: Run Button
- Open Java file with `main` method
- Click **Run** button above method
- View output in terminal

### Method 2: Debug Menu
- Press `F5` or use Debug menu
- Select configuration
- View output and set breakpoints

### Method 3: Terminal
```bash
cd module07-fileio-exceptions
./compile.sh
./run.sh
```

## 🐛 Debugging

1. Set breakpoint (click left of line number)
2. Press `F5` to start debugging
3. Use debug toolbar:
   - Continue (F5)
   - Step Over (F10)
   - Step Into (F11)
   - Step Out (⇧F11)

### Debug with AI
- Ask Claude to help debug
- Describe the issue
- Claude can suggest fixes

## 📝 Common AI Prompts

### Learning
```
"Explain how object serialization works in Java"
"What's the difference between FileInputStream and BufferedReader?"
"Show me an example of try-with-resources"
```

### Code Generation
```
"Create a method that reads CSV files"
"Add a menu option for [new feature]"
"Generate test cases for this method"
```

### Refactoring
```
"Refactor this to follow Java naming conventions"
"Extract this logic into a separate method"
"Add proper exception handling to this code"
```

### Documentation
```
"Add javadoc comments to this class"
"Create a README for this module"
"Document this complex algorithm"
```

## 🎨 Customization

### Settings (⌘,)
- Search for settings
- Modify Java, Editor, or Cursor settings
- Changes save automatically

### Themes
- `⌘K` `⌘T` to change color theme
- Material Theme recommended
- Material Icon Theme for file icons

## 🔧 Troubleshooting

### AI Not Responding
```
Check: Settings → Cursor → API Keys
Verify: Claude model is selected
Try: Restart Cursor
```

### Java Not Working
```
Check: java -version in terminal
Install: Extension Pack for Java
Verify: Java path in settings
```

### Build Errors
```
Run: ./compile.sh in terminal
Check: Maven installed (mvn -version)
Clean: rm -rf target/
```

## 📚 Learning Workflow

### Recommended Process
1. **Read** the module README
2. **Open** main demo file
3. **Ask Claude** to explain concepts
4. **Run** the demonstration
5. **Modify** code with AI help
6. **Experiment** with variations
7. **Ask** questions when stuck

### Example Session
```
1. Open FileIODemo.java
2. ⌘L: "explain what this demo does"
3. Click Run button
4. Select LowLevelIO.java
5. ⌘K: "add another example method"
6. Save and run again
7. ⌘L: "how does buffering improve performance?"
```

## 💡 Pro Tips

### Productivity
- Use `@Codebase` to understand project structure
- Ask Claude to generate boilerplate code
- Let AI help with naming conventions
- Use Composer for multi-file changes

### Learning
- Ask "why" questions to understand concepts
- Request alternative implementations
- Have Claude explain error messages
- Generate practice exercises

### Code Quality
- Ask for code review
- Request refactoring suggestions
- Have AI add comments
- Get best practice recommendations

## 🎓 Module-Specific Tips

### Module 07 (File I/O)
```
"Show me all three I/O layers side by side"
"Explain when to use each type of stream"
"What happens if I don't close a file?"
"How do try-with-resources work?"
```

### Future Modules
- Follow same patterns
- Use .cursorrules for context
- Ask AI to explain new concepts
- Generate practice problems

## 📖 Resources

- **Cursor Docs**: [docs.cursor.sh](https://docs.cursor.sh)
- **Project Setup**: See `CURSOR_SETUP.md`
- **Module Docs**: Each module has README
- **Java Docs**: [docs.oracle.com/javase](https://docs.oracle.com/javase/)

---

**Remember**: Claude is here to help you learn! Don't hesitate to ask questions, request explanations, or try experiments.

**Quick Start**: Open `module07-fileio-exceptions/src/main/java/com/cs18000/module07/FileIODemo.java` and press **Run**!
