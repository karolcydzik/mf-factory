REM Workbench Table Data copy script
REM 
REM Execute this to copy table data from a source RDBMS to MySQL.
REM Edit the options below to customize it. You will need to provide passwords, at least.
REM 
REM Source DB: Mysql@127.0.0.1:3306 (MySQL)
REM Target DB: Mysql@localhost:3306


@ECHO OFF
REM Source and target DB passwords
set arg_source_password=
set arg_target_password=

IF [%arg_source_password%] == [] (
    IF [%arg_target_password%] == [] (
        ECHO WARNING: Both source and target RDBMSes passwords are empty. You should edit this file to set them.
    )
)
set arg_worker_count=2
REM Uncomment the following options according to your needs

REM Whether target tables should be truncated before copy
set arg_truncate_target=--truncate-target
REM Enable debugging output
REM set arg_debug_output=--log-level=debug3


REM Creation of file with table definitions for copytable

set table_file="%TMP%\wb_tables_to_migrate.txt"
TYPE NUL > "%TMP%\wb_tables_to_migrate.txt"
ECHO `mpfactory`	`district`	`mpfactory`	`district`	`ID`, `NAME`, `CITY_ID` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `mpfactory`	`agglo_name`	`mpfactory`	`agglo_name`	`ID`, `NAME`, `STATE_ID` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `mpfactory`	`company`	`mpfactory`	`company`	`ID`, `NAME`, `FULL_NAME`, `STREET_AND_NR`, `CITY_ID`, `DISTRICT_ID`, `MOBILE`, `PHONE`, `EMAIL`, `WWW`, `ts` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `mpfactory`	`state`	`mpfactory`	`state`	`ID`, `NAME` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `mpfactory`	`city`	`mpfactory`	`city`	`ID`, `NAME`, `ORD`, `STATE_ID` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `mpfactory`	`company_hist`	`mpfactory`	`company_hist`	`ID`, `COMPANY_ID`, `NAME`, `FULL_NAME`, `STREET_AND_NR`, `CITY_ID`, `DISTRICT_ID`, `MOBILE`, `PHONE`, `EMAIL`, `WWW`, `TS` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `mpfactory`	`agglo_connection`	`mpfactory`	`agglo_connection`	`ID`, `AGGLOM_ID`, `CITY_ID` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `mpfactory`	`user`	`mpfactory`	`user`	`ID`, `nick`, `email`, `password_hash`, `status`, `COMPANY_ID` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `mpfactory`	`counter`	`mpfactory`	`counter`	`ID`, `CLASS_NAME`, `LAST_NUMBER` >> "%TMP%\wb_tables_to_migrate.txt"


wbcopytables.exe --mysql-source="mpfactory@127.0.0.1:3306" --target="root@localhost:3306" --source-password="%arg_source_password%" --target-password="%arg_target_password%" --table-file="%table_file%" --thread-count=%arg_worker_count% %arg_truncate_target% %arg_debug_output%

REM Removes the file with the table definitions
DEL "%TMP%\wb_tables_to_migrate.txt"


