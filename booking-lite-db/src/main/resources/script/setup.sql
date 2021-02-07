
USE BOOKINGDB;

CREATE TABLE `bookingdb`.`cities` (
  `city_id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(45) NOT NULL,
  `city_name` VARCHAR(45) NOT NULL,
  `vehicles_available` INT ZEROFILL NULL,
  PRIMARY KEY (`city_id`));

CREATE TABLE `bookingdb`.`bookings` (
  `booking_id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(45) NOT NULL,
  `source` INT NOT NULL,
  `destination` INT NOT NULL,
  `pickup_date` DATE NOT NULL,
  `cost` DOUBLE ZEROFILL NULL,
  PRIMARY KEY (`booking_id`),
  INDEX `source_idx` (`source` ASC),
  INDEX `destination_idx` (`destination` ASC),
  CONSTRAINT `source`
    FOREIGN KEY (`source`)
    REFERENCES `bookingdb`.`cities` (`city_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `destination`
    FOREIGN KEY (`destination`)
    REFERENCES `bookingdb`.`cities` (`city_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

CREATE TABLE `bookingdb`.`fares` (
  `source_id` INT NOT NULL,
  `destination_id` INT NOT NULL,
  `fare` DOUBLE ZEROFILL NULL,
  INDEX `source_id_idx` (`source_id` ASC),
  INDEX `destination_id_idx` (`destination_id` ASC),
  CONSTRAINT `source_id`
    FOREIGN KEY (`source_id`)
    REFERENCES `bookingdb`.`cities` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `destination_id`
    FOREIGN KEY (`destination_id`)
    REFERENCES `bookingdb`.`cities` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `bookingdb`.`fares`
ADD PRIMARY KEY (`source_id`, `destination_id`);
;

