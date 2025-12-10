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
/review @./src/service.py
```

### /test-gen
Generates comprehensive unit tests with:
- Full method coverage
- Edge cases and error conditions
- Proper mocking setup
- Test fixtures

**Usage:**
```
/test-gen @./src/service.py
```

### /docs
Creates documentation including:
- README.md content
- API documentation
- Inline comments/docstrings

**Usage:**
```
/docs @./src/
```

### /refactor
Refactors code for improved quality:
- Modern language features
- Design patterns
- Error handling
- Performance improvements

**Usage:**
```
/refactor @./src/legacy_code.py
```

## Creating Your Own Commands

1. Create a new `.toml` file in `~/.gemini/commands/`
2. Define the command with this structure:

```toml
description = "Brief description for /help menu"

prompt = """
Your prompt template here.
Use {{args}} to include user-provided arguments.

You can also use:
- @{path/to/file} to embed file contents
- !{shell command} to include shell output (requires confirmation)
"""
```

3. The command will be available as `/filename` in Gemini CLI (without the .toml extension)

## Command Format Reference

| Field | Required | Description |
|-------|----------|-------------|
| `description` | Optional | One-line description shown in `/help` |
| `prompt` | Required | The instruction sent to Gemini |

### Injection Methods

- `{{args}}` - Injects user arguments from the command line
- `@{path}` - Embeds file content or directory listing
- `!{cmd}` - Executes shell command and injects output

### Example: Git Commit Message Generator

```toml
description = "Generate a commit message from staged changes"

prompt = """
Generate a Conventional Commit message from this diff:
```diff
!{git diff --staged}
```
"""
```

## Tips

- Keep command names short and memorable
- Use `{{args}}` placeholder for user-provided content
- Be specific in your prompts for better results
- Test commands with various input types
- Use `@{file}` syntax to reference files in your prompts
