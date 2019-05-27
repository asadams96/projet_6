-- User: admin_p6
-- DROP USER admin_p6;

CREATE USER admin_p6 WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION;

COMMENT ON ROLE admin_p6 IS 'Administrateur de la BDD ''db_p6''';