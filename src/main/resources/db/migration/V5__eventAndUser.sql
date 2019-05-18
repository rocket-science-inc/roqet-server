ALTER TABLE `event`
  ADD INDEX `fk_user_org_idx` (`organizer` ASC);
ALTER TABLE `event`
  ADD CONSTRAINT `fk_user_org`
FOREIGN KEY (`organizer`)
REFERENCES `user` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
