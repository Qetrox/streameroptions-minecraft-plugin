# Streamer Options – Minecraft Server Plugin

This is the official Minecraft plugin for the [Streamer Options](https://github.com/Qetrox/streameroptions-expressjs) platform.  
It allows Twitch viewers to trigger in-game events on a Minecraft server by spending points earned while watching the streamer.

## ⚙️ Features

- Connects your Minecraft server to Streamer Options via API
- Allows viewers to trigger events like spawning mobs, executing commands, etc.
- Customizable event commands and cost per action
- Whitelist module with announcement control
- In-game `/streamer` command to manage linked streamers

## 🧾 Commands

| Command | Description | Permission |
|--------|-------------|------------|
| `/streamer add <player>` | Add a player to the list of affected streamers | `streameroptions.changestreamer` |
| `/streamer remove <player>` | Remove a player from the list | `streameroptions.changestreamer` |
| `/streamer list` | List all configured streamers | _Everyone_ |

If no arguments are given, the command will show usage info.

## 🔐 Permissions

- `streameroptions.changestreamer`  
  Required to add/remove players via the `/streamer` command.

## 🛠 Configuration

```yaml
enabled: true

# Token from the Streamer Options dashboard (used to link your server)
token: 'your-token-here'

# UUIDs of streamers (with dashes) who can be affected by viewer actions
streamer_uuids:
  - '069a79f4-44e9-4726-a5be-fca90e38aaf5'
  - 'uuid-of-another-streamer'

# Whitelist module setting
announce_whitelisted_player: true
```
Note: You can manage streamer_uuids manually in this file or using the /streamer command in-game.

## ✅ Requirements
- Minecraft Server (Spigot 1.16+ recommended)
- Java 8 or higher
- Valid token from the Streamer Options platform

## 📦 Status
This plugin is no longer actively maintained but remains available as a reference and archive.
