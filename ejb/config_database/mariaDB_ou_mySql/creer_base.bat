REM lancer si besoin le service mysql (net start mysql ou mariadb)
REM set MYSQL_HOME=C:\Prog\DB\MySql5
set MYSQL_HOME=C:\Program Files\MariaDB 10.4
cd /d %~dp0
REM mot de passe souvent root ou formation ou rien
"%MYSQL_HOME%\bin\mysql"  -u root -p < create_db.sql
pause