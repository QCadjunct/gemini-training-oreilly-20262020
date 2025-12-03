# Custom Commands

This folder contains example custom commands for Gemini CLI.

## Installation

Copy the desired command files to your Gemini CLI commands directory:

```bash
# Copy all commands
cp *.toml ~/.gemini/commands/

# Or copy specific commands
cp review.toml ~/.gemini/commands/
```

## Available Commands

### /review
Performs a comprehensive code review focusing on:
- Security vulnerabilities
- Performance issues
- Best practices
- Testing coverage

**Usage:**
```
/review
[Then provide the file path or paste the code]
```

### /test-gen
Generates comprehensive unit tests with:
- Full method coverage
- Edge cases and error conditions
- Proper mocking setup
- Test fixtures

**Usage:**
```
/test-gen
[Then reference the file: @./src/service.py]
```

### /docs
Creates documentation including:
- README.md content
- API documentation
- Inline comments/docstrings

**Usage:**
```
/docs
[Then reference the code: @./src/]
```

### /refactor
Refactors code for improved quality:
- Modern language features
- Design patterns
- Error handling
- Performance improvements

**Usage:**
```
/refactor
[Then provide the code to refactor]
```

## Creating Your Own Commands

1. Create a new `.toml` file in `~/.gemini/commands/`
2. Define the command structure:

```toml
[command]
name = "my-command"
description = "What this command does"

[prompt]
template = """
Your prompt template here.
Use {{input}} to include user input.
"""
```

3. The command will be available as `/my-command` in Gemini CLI

## Tips

- Keep command names short and memorable
- Use `{{input}}` placeholder for user-provided content
- Be specific in your prompts for better results
- Test commands with various input types
