#!/bin/bash

LOGFILE="script.log"
log () {
	echo "$1" | tee -a "$LOGFILE"
}

# -d argument handling
while getopts "d:" opt; do
	case "$opt" in 
		d) WORKDIR_BASE="$OPTARG" ;;
	esac
done

if [ -z "$WORKDIR_BASE" ]; then
	read -rp "Enter the path where you want to create the directories: " WORKDIR_BASE
fi

WORKDIR_BASE="${WORKDIR_BASE%/}"
log "Base directory for working catalogs: $WORKDIR_BASE"

# check if directory exists
if [ ! -d "$WORKDIR_BASE" ]; then
	log "Directory $WORKDIR_BASE does not exist. Creating"
	sudo mkdir -p "$WORKDIR_BASE" && log "Created: $WORKDIR_BASE" || { log "ERROR: cannot create working directory"; exit 1; }
fi

log "Getting all non-system users"

USERS=$(getent passwd | awk -F: '$3 >= 1000 {print $1}')

log "Non-system users found:"
log "$USERS"

# check if dev group already exists
if getent group dev > /dev/null; then
	log "Group 'dev' already exists"
else
	log "Creating 'dev' group"
	sudo groupadd dev && log "INFO: Group 'dev' has been created" || "ERROR: 'dev' group cannot be created"
fi

# adding non-system users to dev group
for user in $USERS; do
	log "Adding user '$user' to 'dev' group"
	sudo usermod -aG dev "$user" && log "User '$user' has been added to 'dev' group" || log "ERROR: cannot add '$user' to 'dev' group"

done

# adding sudo rights without password to dev group
SUDOERS_FILE="/etc/sudoers.d/dev-nopasswd"

if [ -f "$SUDOERS_FILE" ]; then
	log "File '$SUDOERS_FILE' already exists"
else
	log "Adding sudo without password for 'dev' group"
	echo "%dev ALL=(ALL) NOPASSWD:ALL" | sudo tee "$SUDOERS_FILE" > /dev/null
	sudo chmod 440 "$SUDOERS_FILE"
	log "Sudo right added for 'dev' group"
fi

# creating working directories for each non-system user
for user in $USERS; do
	user_dir="$WORKDIR_BASE/${user}_workdir"
	log "Creating directory for '$user': $user_dir"
	sudo mkdir -p "$user_dir"
	user_group=$(id -gn "$user")
	sudo chown "$user:$user_group" "$user_dir"
	sudo chmod 660 "$user_dir"
	sudo setfacl -m g:dev:rx "$user_dir"
	
	log "Created $user_dir directory: owner-$user, group-$user_group, rights 660 + acl 'read' for 'dev' group"
done
