# Cursor IDE Setup Guide

This guide will help you install and configure Cursor IDE with Claude AI for this Java project.

## 📥 Step 1: Install Cursor

### Download Cursor

1. Go to [cursor.sh](https://cursor.sh)
2. Click **Download for Mac** (or your OS)
3. Open the downloaded `.dmg` file
4. Drag **Cursor** to your Applications folder
5. Launch Cursor from Applications

### First Launch

When you first open Cursor:
- It may ask for permissions - grant them
- It's a fork of VS Code, so the interface will be familiar
- You might see a welcome screen

## 🔑 Step 2: Configure Claude AI

### Option A: Using Cursor Pro (Recommended)

1. In Cursor, click on **Settings** (⌘,) or go to **Cursor** → **Settings**
2. Go to **Features** → **Cursor Tab**
3. You'll see options for AI models
4. Click **Upgrade to Pro** if you want to use Claude
5. Sign up for Cursor Pro (there's usually a free trial)
6. Once subscribed, select **Claude 3.5 Sonnet** as your model

### Option B: Using Your Own Anthropic API Key

1. Go to [console.anthropic.com](https://console.anthropic.com)
2. Sign up or log in
3. Go to **API Keys** section
4. Create a new API key and copy it
5. In Cursor:
   - Open Settings (⌘,)
   - Go to **Features** → **Models**
   - Look for **Anthropic API Key** section
   - Paste your API key
   - Select **Claude 3.5 Sonnet** as your model

### Verify Setup

To test if Claude is working:
1. Open any file
2. Press **⌘K** (or Ctrl+K on Windows/Linux)
3. Type a question like "explain this code"
4. If you see a response, Claude is configured!

## 🎨 Step 3: Install Java Extensions

Cursor supports VS Code extensions. Install these for Java development:

### Required Extensions

1. **Extension Pack for Java** (Microsoft)
   - Open Extensions view (⌘⇧X)
   - Search for "Extension Pack for Java"
   - Click Install
   - This includes:
     - Language Support for Java
     - Debugger for Java
     - Test Runner for Java
     - Maven for Java
     - Project Manager for Java

2. **Java Extension Pack** includes:
   - IntelliCode
   - Visual Studio IntelliCode

### Optional but Recommended

- **GitLens** - Enhanced Git features
- **Error Lens** - Inline error display
- **Prettier** - Code formatting
- **Material Icon Theme** - Better file icons

## 📂 Step 4: Open the Project

### Open in Cursor

```bash
# Option 1: From terminal
cd /Users/sada/work/java-examples
cursor .

# Option 2: From Cursor menu
# File → Open Folder → Navigate to java-examples
```

### Trust the Workspace

When you open the project:
1. Cursor will ask if you trust the authors
2. Click **Yes, I trust the authors**
3. This allows the project to use custom settings

## ⚙️ Step 5: Configure Java Environment

### Check Java Installation

1. Open Cursor Terminal (⌃\`)
2. Run:
   ```bash
   java -version
   ```
3. Should show Java 11 or higher

### Configure Java Path (if needed)

If Java isn't detected:
1. Open Settings (⌘,)
2. Search for "java.home"
3. Click **Edit in settings.json**
4. Add:
   ```json
   {
     "java.home": "/opt/homebrew/opt/openjdk"
   }
   ```

## 🚀 Step 6: Test the Setup

### Run Module 07 Demo

1. Open `module07-fileio-exceptions/src/main/java/com/cs18000/module07/FileIODemo.java`
2. You should see a **Run | Debug** button above the `main` method
3. Click **Run**
4. The program should compile and run in the terminal

### Test AI Features

#### Cursor Chat (⌘L)
- Press **⌘L** to open Cursor Chat
- Ask: "Explain what this project does"
- Claude should analyze the codebase and explain

#### Inline Edit (⌘K)
- Select some code
- Press **⌘K**
- Type: "add comments to this code"
- Claude will suggest improvements

#### Autocomplete
- Start typing code
- Cursor will suggest completions powered by Claude

## 🎯 Cursor-Specific Features

### Composer (⌘I)
- Multi-file editing with AI
- Press **⌘I** to open Composer
- Describe what you want across multiple files

### Chat with Codebase
- Use **@Codebase** in chat to ask about your entire project
- Example: "@Codebase where are exceptions handled?"

### Terminal Commands
- Use **⌘K** in terminal for AI command suggestions
- Example: Type "list all java files" and press ⌘K

## 📝 Using .cursorrules

The project includes a `.cursorrules` file that tells Cursor AI how to work with this codebase:
- Coding style guidelines
- Project structure
- Educational focus
- Best practices

Cursor reads this automatically when you open the project!

## 🛠️ Keyboard Shortcuts

Essential Cursor shortcuts:
- **⌘L** - Open Chat
- **⌘K** - Inline edit/generate
- **⌘I** - Open Composer
- **⌘⇧P** - Command Palette
- **⌃\`** - Toggle Terminal
- **⌘P** - Quick file open
- **⌘⇧F** - Search in files

## 🐛 Troubleshooting

### Java Not Detected
```bash
# Install Java if needed
brew install openjdk@11

# Set JAVA_HOME
export JAVA_HOME=/opt/homebrew/opt/openjdk@11
```

### Cursor Not Opening from Terminal
```bash
# Install Cursor CLI tools
# In Cursor: ⌘⇧P → "Shell Command: Install 'cursor' command in PATH"
```

### Extensions Not Loading
- Restart Cursor
- Check Extensions view (⌘⇧X)
- Make sure Java Extension Pack is installed

### AI Not Responding
- Check your API key/subscription in Settings
- Try switching between Claude models
- Restart Cursor

## 🎓 Learning Resources

### Cursor Specific
- [Cursor Documentation](https://docs.cursor.sh)
- [Cursor YouTube Channel](https://youtube.com/@cursor)
- [Cursor Community Forum](https://forum.cursor.sh)

### Using with This Project
1. Open any Java file
2. Ask Claude to explain concepts
3. Use ⌘K to generate examples
4. Use Chat to explore the codebase
5. Let AI help with debugging

## ✅ Verification Checklist

Before starting development, verify:
- [ ] Cursor is installed and opens
- [ ] Claude AI responds in Chat (⌘L)
- [ ] Java extensions are installed
- [ ] Java version is 11+ (`java -version`)
- [ ] Project opens without errors
- [ ] FileIODemo.java can run
- [ ] Terminal commands work
- [ ] .cursorrules file is detected

## 🎉 You're Ready!

Once everything is set up:
1. Explore the Module 07 examples
2. Use Cursor's AI features to learn
3. Try modifying code with AI assistance
4. Ask questions about Java concepts

---

**Need Help?** Open an issue on GitHub or ask Claude in Cursor Chat!
