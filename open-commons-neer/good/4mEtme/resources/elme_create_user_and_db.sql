START TRANSACTION;

CREATE USER 'etme'@'localhost' IDENTIFIED BY 'etme';

CREATE DATABASE IF NOT EXISTS StartupMigrationEngine
    CHARACTER SET utf8
    COLLATE utf8_general_ci;

GRANT ALL ON StartupMigrationEngine.* TO 'etme'@'localhost';

grant all on *.* to 'etme'@'localhost' identified by 'etme';

grant all PRIVILEGES on *.* to 'etme'@'localhost' with grant option;

grant reload,process on *.* to 'etme'@'localhost';

FLUSH PRIVILEGES;
COMMIT;

