#!/bin/bash
set -a
source .env
set +a
ansible-playbook "$@"

