# Gemini CLI Training Course

A comprehensive training course for mastering Google Gemini CLI - the open-source AI agent that brings Gemini directly into your terminal.

## Course Overview

This 5-hour hands-on workshop covers everything from basic installation to advanced MCP configurations, custom commands, and enterprise workflows.

### What You'll Learn

- **Installation & Setup**: Authentication strategies, environment configuration
- **Core Commands**: Interactive mode, one-shot prompts, file references
- **Context Management**: GEMINI.md files, hierarchical context loading
- **Safety & Control**: Sandbox modes, approval policies, checkpointing
- **Advanced Features**: MCP integration, extensions, custom commands
- **Practical Skills**: Real-world exercises in Python, JavaScript, and Java

## Prerequisites

- Node.js 18+ installed
- Command-line experience
- Basic programming knowledge in at least one language
- Git familiarity
- Docker (optional, for sandbox mode)
- Google account for API access

## Repository Structure

```
gemini-training/
├── slides.md                     # Slidev presentation
├── lab_handout.md               # Progressive hands-on labs
├── exercises/                    # Hands-on lab projects
│   ├── python/                  # Python projects
│   │   └── weather-app/         # Flask weather application
│   ├── javascript/              # JavaScript/TypeScript projects
│   │   └── task-manager/        # Node.js task manager
│   └── java/                    # Java projects
│       └── bookstore-api/       # Spring Boot REST API
├── config-examples/              # Sample configurations
│   ├── settings.json            # Full settings.json example
│   └── mcp-servers.json         # MCP server configurations
├── gemini-md-examples/          # GEMINI.md templates
│   ├── python-project.md        # Python project template
│   ├── java-spring.md           # Spring Boot template
│   └── javascript-react.md      # React project template
└── commands/                     # Custom command examples
    ├── review.md                # Code review command
    └── test-gen.md              # Test generation command
```

## Quick Start

### 1. Install Gemini CLI

```bash
# Via npm (recommended)
npm install -g @google/gemini-cli

# Verify installation
gemini --version
```

### 2. Authenticate

```bash
# Set API key (get from https://aistudio.google.com/apikey)
export GEMINI_API_KEY="your-api-key"

# Or add to ~/.gemini/.env
echo 'GEMINI_API_KEY=your-api-key' >> ~/.gemini/.env
```

### 3. Run Your First Command

```bash
gemini "Hello! What can you help me with?"
```

### 4. Start the Training

```bash
# Clone this repository
git clone https://github.com/kousen/gemini-training
cd gemini-training

# Install dependencies for slides
npm install

# Start the presentation
npm run dev

# Open browser to http://localhost:3030
```

## Course Schedule

| Section | Duration |
|---------|----------|
| Introduction & Setup | 10 min |
| Installation & Prerequisites | 15 min |
| Authentication & Account Setup | 10 min |
| First Steps & Basic Interface | 15 min |
| Core Commands & Functionality | 65 min |
| Configuration & Customization | 65 min |
| Advanced Features & Extensions | 65 min |
| Practical Applications & Workflows | 45 min |
| Wrap-up & Q&A | 15 min |

## Key Gemini CLI Features Covered

### Core Features
- Interactive REPL and one-shot modes
- File references with `@` syntax
- Shell integration with `!` prefix
- Sandbox mode for safe execution
- YOLO mode for autonomous operation

### Configuration
- GEMINI.md context files (hierarchical)
- settings.json customization
- Environment variables
- Custom commands

### Advanced Features
- Model Context Protocol (MCP) servers
- Extensions system
- Session management and checkpointing
- IDE integration (VS Code)

## Tips for Success

1. **Start in Default Mode**: Get comfortable before enabling YOLO mode
2. **Use GEMINI.md**: Provide context for better, more consistent results
3. **Enable Checkpointing**: Save snapshots before risky operations
4. **Review Generated Code**: Always verify AI-generated changes
5. **Leverage MCP**: Extend capabilities with custom tools

## Useful Commands Reference

```bash
# Basic usage
gemini                          # Interactive mode
gemini "prompt"                 # One-shot mode
gemini -i "context"             # Interactive with initial prompt

# Configuration
gemini --sandbox                # Run in sandbox mode
gemini --yolo                   # Auto-approve all actions
gemini --model gemini-2.5-pro   # Specify model

# Session management
gemini --resume latest          # Resume last session
gemini --list-sessions          # Show available sessions
```

## Slash Commands

| Command | Description |
|---------|-------------|
| `/help` | Show available commands |
| `/clear` | Clear conversation history |
| `/memory show` | View loaded context |
| `/memory refresh` | Reload GEMINI.md files |
| `/init` | Generate project GEMINI.md |
| `/chat save <tag>` | Save conversation |
| `/restore` | Recover from checkpoint |
| `/compress` | Summarize conversation |

## Resources

- [Official Gemini CLI Documentation](https://github.com/google-gemini/gemini-cli)
- [Google AI Studio](https://aistudio.google.com/) - Get API keys
- [MCP Server Registry](https://modelcontextprotocol.io/registry)
- [Course Slides](./slides.md)
- [Lab Exercises](./lab_handout.md)

## Instructor

**Kenneth Kousen**
- President, Kousen IT, Inc.
- Author & Technical Trainer
- ken.kousen@kousenit.com
- https://www.kousenit.com

## License

This training material is licensed under the MIT License. See [LICENSE](./LICENSE) file for details.

---

**Ready to start?** Run `npm run dev` and navigate to http://localhost:3030!
