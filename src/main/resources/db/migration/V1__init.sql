DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `organizer` INT(10) NOT NULL,
  `start` DATETIME NOT NULL,
  `end` DATETIME NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `image` VARCHAR(255) NULL,
  `description` TEXT NULL,
  `ticket_link` VARCHAR(255) NULL,
  `agenda` TEXT NULL,
  PRIMARY KEY (`id`));
