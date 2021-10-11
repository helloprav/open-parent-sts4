set "crt_dir=%~dp0"
cd ..\mysql-8.0.19-winx64\bin
rem mysql -u root --skip-password -e "alter user 'root'@'localhost' identified by 'root';"
mysql --defaults-extra-file=%crt_dir%/mysql.cnf
cd %crt_dir%
