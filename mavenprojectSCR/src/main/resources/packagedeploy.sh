#!/bin/bash
echo Starting	# This is a comment, too!

cd /Users/andrewhinton/Documents/GitHub/wizardfrontendToday/mavenprojectSCR

export  "JAVA_HOME=/Applications/Apache NetBeans.app/Contents/Home"

"/Applications/Apache NetBeans.app/Contents/Resources/netbeans/java/maven/bin/mvn" -DskipTests=true --no-transfer-progress install


# Define your variables
USER="wizard"
HOST="97.74.232.85"
PASSWD='Superman123#'
REMOTE_DIR="/deploy"
LOCAL_FILE="/path/to/local/file.txt"

# Run SFTP in batch mode via Heredoc
sftp -o BatchMode=no "$USER@$HOST" <<EOF
cd "$REMOTE_DIR"
put "$LOCAL_FILE"
bye
EOF