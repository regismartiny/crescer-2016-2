CREATE TABLE Personagem
  (
    Id               INTEGER NOT NULL ,
    Imagem           VARCHAR (100) ,
    Nome             VARCHAR (100) NOT NULL ,
    DataNascimento   DATE NOT NULL ,
    Altura           INTEGER NOT NULL ,
    Peso             DECIMAL (6,2) NOT NULL ,
    Origem           CHAR (2) NOT NULL ,
    GolpesEspeciais  VARCHAR (250) ,
    PersonagemOculto BIT NOT NULL
  ) ;
ALTER TABLE Personagem ADD CONSTRAINT Personagem_PK PRIMARY KEY ( Id ) ;
