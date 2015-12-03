-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: mpfactory
-- Source Schemata: mpfactory
-- Created: Sat Sep 20 14:28:21 2014
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;;

-- ----------------------------------------------------------------------------
-- Schema mpfactory
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `mpfactory` ;
CREATE SCHEMA IF NOT EXISTS `mpfactory` ;

-- ----------------------------------------------------------------------------
-- Table mpfactory.agglo_connection
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `mpfactory`.`agglo_connection` (
  `ID` BIGINT(20) NOT NULL,
  `AGGLOM_ID` BIGINT(20) NULL DEFAULT NULL,
  `CITY_ID` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID` (`ID` ASC),
  INDEX `FK_AG_CO_AGGLOM_ID` (`AGGLOM_ID` ASC),
  INDEX `FK_AG_CO_CITY_ID` (`CITY_ID` ASC),
  CONSTRAINT `CON_AG_CO_AGGLOM_ID`
    FOREIGN KEY (`AGGLOM_ID`)
    REFERENCES `mpfactory`.`agglo_name` (`ID`),
  CONSTRAINT `CON_AG_CO_CITY_ID`
    FOREIGN KEY (`CITY_ID`)
    REFERENCES `mpfactory`.`city` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

-- ----------------------------------------------------------------------------
-- Table mpfactory.agglo_name
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `mpfactory`.`agglo_name` (
  `ID` BIGINT(20) NOT NULL,
  `NAME` VARCHAR(60) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `STATE_ID` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID` (`ID` ASC),
  INDEX `FK_AG_NA_STATE` (`STATE_ID` ASC),
  CONSTRAINT `CON_AG_NA_STATE`
    FOREIGN KEY (`STATE_ID`)
    REFERENCES `mpfactory`.`state` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

-- ----------------------------------------------------------------------------
-- Table mpfactory.city
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `mpfactory`.`city` (
  `ID` BIGINT(20) NOT NULL,
  `NAME` VARCHAR(60) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `ORD` BIGINT(20) NULL DEFAULT NULL,
  `STATE_ID` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID` (`ID` ASC),
  INDEX `FK1F916B28714843` (`STATE_ID` ASC),
  INDEX `idx_city_STATE_ID` (`STATE_ID` ASC),
  CONSTRAINT `FK1F916B28714843`
    FOREIGN KEY (`STATE_ID`)
    REFERENCES `mpfactory`.`state` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

-- ----------------------------------------------------------------------------
-- Table mpfactory.state
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `mpfactory`.`state` (
  `ID` BIGINT(20) NOT NULL,
  `NAME` VARCHAR(60) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID` (`ID` ASC),
  INDEX `idx_state_NAME` (`NAME` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

-- ----------------------------------------------------------------------------
-- Table mpfactory.company
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `mpfactory`.`company` (
  `ID` BIGINT(20) NOT NULL,
  `NAME` VARCHAR(60) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `FULL_NAME` VARCHAR(160) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `STREET_AND_NR` VARCHAR(160) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `CITY_ID` BIGINT(20) NULL DEFAULT NULL,
  `DISTRICT_ID` BIGINT(20) NULL DEFAULT NULL,
  `MOBILE` VARCHAR(20) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `PHONE` VARCHAR(20) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `EMAIL` VARCHAR(80) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `WWW` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID` (`ID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

-- ----------------------------------------------------------------------------
-- Table mpfactory.company_hist
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `mpfactory`.`company_hist` (
  `ID` BIGINT(20) NOT NULL,
  `COMPANY_ID` BIGINT(20) NOT NULL,
  `NAME` VARCHAR(60) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `FULL_NAME` VARCHAR(160) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `STREET_AND_NR` VARCHAR(160) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `CITY_ID` BIGINT(20) NULL DEFAULT NULL,
  `DISTRICT_ID` BIGINT(20) NULL DEFAULT NULL,
  `MOBILE` VARCHAR(20) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `PHONE` VARCHAR(20) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `EMAIL` VARCHAR(80) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `WWW` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `TS` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID` (`ID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

-- ----------------------------------------------------------------------------
-- Table mpfactory.counter
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `mpfactory`.`counter` (
  `ID` BIGINT(20) NOT NULL,
  `CLASS_NAME` VARCHAR(40) CHARACTER SET 'utf8' NOT NULL,
  `LAST_NUMBER` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID` (`ID` ASC),
  UNIQUE INDEX `CLASS_NAME` (`CLASS_NAME` ASC),
  UNIQUE INDEX `CLASS_NAME_2` (`CLASS_NAME` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

-- ----------------------------------------------------------------------------
-- Table mpfactory.district
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `mpfactory`.`district` (
  `ID` BIGINT(20) NOT NULL,
  `NAME` VARCHAR(60) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `CITY_ID` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID` (`ID` ASC),
  INDEX `FK3FDF238E14C86091` (`CITY_ID` ASC),
  CONSTRAINT `FK3FDF238E14C86091`
    FOREIGN KEY (`CITY_ID`)
    REFERENCES `mpfactory`.`city` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

-- ----------------------------------------------------------------------------
-- Table mpfactory.user
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `mpfactory`.`user` (
  `ID` BIGINT(20) NOT NULL,
  `nick` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `email` VARCHAR(200) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `password_hash` VARCHAR(160) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `status` VARCHAR(20) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `COMPANY_ID` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID` (`ID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;
SET FOREIGN_KEY_CHECKS = 1;;
