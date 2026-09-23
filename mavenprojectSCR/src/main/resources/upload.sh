#!/bin/bash
echo package and deploy war	# This is a comment, too!

cd /Users/andrewhinton/Documents/GitHub/wizardfrontendToday/mavenprojectSCR

export  "JAVA_HOME=/Applications/Apache NetBeans.app/Contents/Home"
echo compiling 	# This is a comment, too!

"/Applications/Apache NetBeans.app/Contents/Resources/netbeans/java/maven/bin/mvn" -DskipTests=true --no-transfer-progress install

cd /Users/andrewhinton/Documents/GitHub/wizardfrontendToday/mavenprojectSCR/target


# Configuration
REMOTE_DIR="/home/wizard/deploy"
HOST="97.74.232.85"
USER="wizard"
export SSHPASS="Superman123#"

echo upload war to remote server


# Run SFTP in batch mode using a Heredoc (<<EOF) to pass commands
sshpass -e sftp -o BatchMode=no -o PubkeyAuthentication=no "$USER@$HOST" <<EOF


cd "$REMOTE_DIR"
put scr.war
bye
EOF

#copy file
echo upload war to remote server
sshpass -p Superman123# ssh wizard@97.74.232.85 "sudo cp /home/wizard/deploy/scr.war /opt/apache-tomcat-10.1.44/webapps/scr.war;echo copiedfile; exit"

