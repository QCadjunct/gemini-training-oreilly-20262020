# GEMINI.md Examples

This folder contains example GEMINI.md files for different project types.

## Files

### python-flask.md
Context file for Python Flask web applications.
- Flask-specific conventions
- SQLAlchemy patterns
- pytest testing standards
- PEP 8 style guide references

### java-spring.md
Context file for Java Spring Boot applications.
- Spring Boot best practices
- JPA entity conventions
- JUnit 5 testing patterns
- Maven build commands

### javascript-react.md
Context file for React TypeScript applications.
- React component patterns
- TypeScript strict mode usage
- Tailwind CSS styling
- Vitest testing setup

### global-context.md
Template for global context at `~/.gemini/GEMINI.md`.
- Personal preferences
- Communication style
- Git workflow standards
- General coding philosophy

## Usage

### Project-Specific Context

Copy the appropriate template to your project root:

```bash
# For a Flask project
cp python-flask.md /path/to/your/project/GEMINI.md

# Customize for your project
vim /path/to/your/project/GEMINI.md
```

### Global Context

Copy the global template to your Gemini CLI config:

```bash
mkdir -p ~/.gemini
cp global-context.md ~/.gemini/GEMINI.md

# Customize with your preferences
vim ~/.gemini/GEMINI.md
```

## Best Practices

### Keep It Focused
- Include only relevant information
- Remove sections that don't apply
- Update as the project evolves

### Be Specific
- Name actual files and directories
- Include real commands used in the project
- Reference actual technologies and versions

### Use Imports for Large Contexts
Break down large GEMINI.md files:

```markdown
# GEMINI.md

## Project Overview
This is our main application.

## Coding Standards
@./docs/coding-standards.md

## API Guidelines
@./docs/api-guidelines.md
```

### Hierarchical Context
Use subdirectory GEMINI.md files for component-specific rules:

```
project/
├── GEMINI.md              # Project-wide rules
├── frontend/
│   └── GEMINI.md          # React-specific rules
└── backend/
    └── GEMINI.md          # Python-specific rules
```

## Verification

After setting up your GEMINI.md, verify it's loaded:

```bash
gemini
/memory show
```

This shows the combined context from all loaded GEMINI.md files.
