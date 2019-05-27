-- Database: db_p6

-- DROP DATABASE db_p6;

CREATE DATABASE db_p6
    WITH 
    OWNER = admin_p6
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE db_p6
    IS 'Base de donnée du projet 6';