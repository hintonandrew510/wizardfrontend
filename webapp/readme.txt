ssh wizard@97.74.232.85 password Superman123#

/etc/cron.daily

database backups
/home/databasebackup

stat -f '%Su' /home/databasebackup
sudo chmod -R 777 /home/databasebackup


sshpass -p Superman123# ssh wizard@97.74.232.85 "cp /home/backups/23May2020/license-23May2020.sql .;echo copiedfileWorked; exit"

wwizard241@gmail.com
wizardXX123