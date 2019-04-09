DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));



INSERT INTO user ( id, first_name, last_name) VALUES ( 1, 'James', 'Smith');
INSERT INTO user ( id, first_name, last_name) VALUES ( 2, 'John', 'Brown');
INSERT INTO user ( id, first_name, last_name) VALUES ( 3, 'Mary', 'Johnson');
INSERT INTO user ( id, first_name, last_name) VALUES ( 4, 'Patricia', 'Ross');
INSERT INTO user ( id, first_name, last_name) VALUES ( 5, 'William', 'Lopez');
INSERT INTO user ( id, first_name, last_name) VALUES ( 6, 'Michael', 'Morgan');
INSERT INTO user ( id, first_name, last_name) VALUES ( 7, 'Linda', 'Coleman');
INSERT INTO user ( id, first_name, last_name) VALUES ( 8, 'Elizabeth', 'Patterson');
INSERT INTO user ( id, first_name, last_name) VALUES ( 9, 'Thomas', 'Baker');
INSERT INTO user ( id, first_name, last_name) VALUES ( 10, 'Jessica', 'Mitchell');
