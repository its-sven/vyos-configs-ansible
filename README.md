# SQConfigs

Ansible playbooks to manage VyOS infrastructure: export host configurations, migrate them to the latest version, compare results, and generate reports.

## Project Structure

- `inventory/hosts.yml`: YAML inventory of all devices
- `group_vars/all.yml`: Global variables (e.g., path definitions)
- `playbooks/`: Playbooks for config operations
- `configs-exported/`: Backup of original configurations
- `configs-migrated/`: Migrated configurations
- `setfiles-exported/`: Backup of configurations in `set` command format
- `setfiles-migrated/`: Migrated `set` command configs

## Usage

```bash
# Exports the configs of all hosts defined in `inventory/hosts.yml`
./run-playbook.sh playbooks/export_vyos_config.yml

# Copies configs to the migrating-host, upgrades them to its version, and saves them
./run-playbook.sh playbooks/copy_config_and_update.yml

# Parses migrated set-configs in 'setfiles-migrated', extracts data, and writes a 'report.csv'
./run-playbook.sh playbooks/parse_migrated_configs.yml


## Requirements

- Ansible v2.10+ 
```
brew install ansible

# Optional: for password-based SSH
# brew install esolitos/ipa/sshpass

```

## Environment (Passwords)

Copy the `.env_example` file to `.env' and add your password profiles.

```
cp .env_example .env
```

_The '.env' file is git-ignored and will not be tracked._


## Troubleshooting

Some tasks require accepted SSH fingerprints. To ensure all hosts are reachable and known:

```
ansible all -m ping
```
