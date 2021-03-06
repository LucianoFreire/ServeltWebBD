SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema u831468724_ifms
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `u831468724_ifms` DEFAULT CHARACTER SET utf8 ;
USE `u831468724_ifms` ;

-- -----------------------------------------------------
-- Table `u831468724_ifms`.`aluno_responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `u831468724_ifms`.`aluno_responsavel` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `matricula` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `u831468724_ifms`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `u831468724_ifms`.`estado` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sigla` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `u831468724_ifms`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `u831468724_ifms`.`cidade` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `id_estado` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cidade_estado1_idx` (`id_estado` ASC),
  CONSTRAINT `fk_cidade_estado1`
    FOREIGN KEY (`id_estado`)
    REFERENCES `u831468724_ifms`.`estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `u831468724_ifms`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `u831468724_ifms`.`endereco` (
  `id` INT(11) NOT NULL,
  `rua` VARCHAR(75) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `numero` INT(11) NULL DEFAULT NULL,
  `complemento` VARCHAR(75) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `id_cidade` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_endereco_cidade1_idx` (`id_cidade` ASC),
  CONSTRAINT `fk_endereco_cidade1`
    FOREIGN KEY (`id_cidade`)
    REFERENCES `u831468724_ifms`.`cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `u831468724_ifms`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `u831468724_ifms`.`pessoa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(75) NOT NULL,
  `id_aluno_responsavel` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_pessoa_aluno_responsavel1_idx` (`id_aluno_responsavel` ASC),
  CONSTRAINT `fk_pessoa_aluno_responsavel1`
    FOREIGN KEY (`id_aluno_responsavel`)
    REFERENCES `u831468724_ifms`.`aluno_responsavel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `u831468724_ifms`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `u831468724_ifms`.`telefone` (
  `id` INT(11) NOT NULL,
  `dd` INT(11) NOT NULL,
  `numero` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



#######################################
SELECT * FROM pessoa;

DESC pessoa;

TRUNCATE TABLE pessoa;

#######################################
SELECT * FROM aluno_responsavel;

DESC aluno_responsavel;

TRUNCATE TABLE aluno_responsavel;

#######################################
DESC CIDADE;

SELECT * FROM CIDADE;

TRUNCATE TABLE CIDADE;

#######################################
DESC ESTADO;

SELECT * FROM ESTADO;

TRUNCATE TABLE ESTADO;

#######################################

DESC TELEFONE;

SELECT * FROM TELEFONE;

TRUNCATE TABLE TELEFONE;

#######################################

DESC ENDERECO;

SELECT * FROM ENDERECO;

TRUNCATE TABLE ENDERECO;

#######################################


SET FOREIGN_KEY_CHECKS = 0;

SET FOREIGN_KEY_CHECKS = 1;


insert into aluno_responsavel
(id, nome, sobrenome, matricula)
values
(01, 'Luciano1', 'freire', 8);


# Alterando tabela ADICIONANDO A COLUNA PROFISSAO DEPOIS DO NOME
alter table pessoa add column idconjuge_pessoa int after email;
