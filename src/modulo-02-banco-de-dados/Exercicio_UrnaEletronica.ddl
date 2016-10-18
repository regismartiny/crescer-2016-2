-- Gerado por Oracle SQL Developer Data Modeler 4.1.5.907
--   em:        2016-10-18 17:13:02 BRST
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Candidato
  (
    IDCandidato    INTEGER NOT NULL ,
    NomeCompleto   VARCHAR2 (30) NOT NULL ,
    NomePopular    VARCHAR2 (30) NOT NULL ,
    DataNascimento DATE NOT NULL ,
    Cidade         VARCHAR2 (30) NOT NULL ,
    Estado         CHAR (2) NOT NULL ,
    RegistroTRE    VARCHAR2 (5) NOT NULL ,
    Partido        VARCHAR2 (10) NOT NULL ,
    Foto           VARCHAR2 (40) NOT NULL ,
    Numero         VARCHAR2 (5) NOT NULL ,
    IDCargo        INTEGER NOT NULL
  ) ;
ALTER TABLE Candidato ADD CONSTRAINT Candidato_PK PRIMARY KEY ( IDCandidato ) ;
ALTER TABLE Candidato ADD CONSTRAINT UK_Candidato UNIQUE ( RegistroTRE , Numero ) ;


CREATE TABLE Cargo
  (
    IDCargo   INTEGER NOT NULL ,
    NomeCargo VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE Cargo ADD CONSTRAINT Cargo_PK PRIMARY KEY ( IDCargo ) ;


CREATE TABLE Eleitor
  (
    IDEleitor      INTEGER NOT NULL ,
    NomeCompleto   VARCHAR2 (30) NOT NULL ,
    TituloEleitor  VARCHAR2 (10) NOT NULL ,
    RG             VARCHAR2 (10) NOT NULL ,
    DataNascimento DATE NOT NULL ,
    Zona           CHAR (2) NOT NULL ,
    Secao          CHAR (2) NOT NULL ,
    Votou          CHAR (1) NOT NULL
  ) ;
ALTER TABLE Eleitor ADD CONSTRAINT Eleitor_PK PRIMARY KEY ( IDEleitor ) ;
ALTER TABLE Eleitor ADD CONSTRAINT UK_Eleitor UNIQUE ( TituloEleitor , RG ) ;


CREATE TABLE Votos
  (
    IDVoto      INTEGER NOT NULL ,
    IDCandidato INTEGER NOT NULL
  ) ;
ALTER TABLE Votos ADD CONSTRAINT Votos_PK PRIMARY KEY ( IDVoto ) ;


ALTER TABLE Candidato ADD CONSTRAINT Candidato_Cargo_FK FOREIGN KEY ( IDCargo ) REFERENCES Cargo ( IDCargo ) ;

ALTER TABLE Votos ADD CONSTRAINT Votos_Candidato_FK FOREIGN KEY ( IDCandidato ) REFERENCES Candidato ( IDCandidato ) ;


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              8
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
