# Configuration Examples

This folder contains example `settings.json` configurations for Gemini CLI.
They use the current nested schema (`general`, `ui`, `tools`, `context`, etc.).

## Files

### settings-basic.json
Minimal configuration for beginners. Enables checkpointing for safety while keeping most other features near defaults.

**Use when**: Getting started with Gemini CLI

### settings-advanced.json
Full-featured configuration with:
- Vim mode enabled
- Tips and banner hidden for cleaner interface
- Tool output summarization for shell output
- File filtering with `.gitignore` and `.geminiignore`
- Explicit tool allow/exclude lists

**Use when**: You're comfortable with Gemini CLI and want optimal productivity

### settings-safe.json
Restricted configuration for maximum safety:
- Sandbox mode enabled (`docker`)
- Only read-only tools allowed
- Shell and write operations disabled
- Session turn limits
- YOLO mode disabled

**Use when**: Exploring untrusted codebases or training new users

### settings-mcp.json
Configuration with MCP server integrations:
- GitHub server for repo/issue operations
- Filesystem server for extended file access
- PostgreSQL server for database queries
- Global MCP allow/exclude controls via `mcp.allowed` / `mcp.excluded`

**Use when**: You need to integrate with external tools and services

## Usage

Copy the desired configuration to your project or user settings:

```bash
# Project-specific settings
mkdir -p .gemini
cp settings-advanced.json .gemini/settings.json

# User-level settings (all projects)
cp settings-advanced.json ~/.gemini/settings.json
```

## Environment Variables

MCP configurations use `$VAR_NAME` (or `${VAR_NAME}`) syntax for environment variable substitution. Set these before starting Gemini CLI:

```bash
export GITHUB_TOKEN="your-github-token"
export DATABASE_URL="postgres://user:pass@localhost:5432/db"
```

Or add them to your `.gemini/.env` file:

```
GITHUB_TOKEN=your-github-token
DATABASE_URL=postgres://user:pass@localhost:5432/db
```
