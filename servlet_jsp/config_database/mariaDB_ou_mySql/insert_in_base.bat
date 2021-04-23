REM lancer si besoin le service mysql (net start mysql)
REM set MYSQL_HOME=C:\Prog\DB\MySql5
set MYSQL_HOME=C:\Program Files\MariaDB 10.4
cd /d %~dp0
"%MYSQL_HOME%\bin\mysql"  -u root -p < insert_db.sql
pause