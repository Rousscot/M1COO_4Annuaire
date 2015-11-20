SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = OFF;
SET check_function_bodies = FALSE;
SET client_min_messages = WARNING;
SET escape_string_warning = OFF;

SET default_tablespace = '';

SET default_with_oids = FALSE;

-- Entry

CREATE SEQUENCE entry_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

CREATE TABLE ENTRY (
  id_entry   INTEGER PRIMARY KEY   NOT NULL DEFAULT nextval('entry_id_seq' :: REGCLASS),
  first_name CHARACTER VARYING(64) NOT NULL,
  last_name  CHARACTER VARYING(64) NOT NULL
);

ALTER SEQUENCE entry_id_seq OWNED BY ENTRY.id_entry;

-- Entry

CREATE SEQUENCE number_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

CREATE TABLE NUMBER (
  id_number INTEGER PRIMARY KEY   NOT NULL DEFAULT nextval('number_id_seq' :: REGCLASS),
  code      CHARACTER VARYING(64) NOT NULL,
  value     CHARACTER VARYING(16) NOT NULL,
  id_entry  INTEGER REFERENCES ENTRY(id_entry)
);

ALTER SEQUENCE number_id_seq OWNED BY NUMBER.id_number;

