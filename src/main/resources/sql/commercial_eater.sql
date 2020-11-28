DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `login_UNIQUE` ON `users` (`login` ASC);

DROP TABLE IF EXISTS `restaurants`;

CREATE TABLE IF NOT EXISTS `restaurants` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(50),
    `address` VARCHAR(45),
    PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `restaurants` (`name` ASC);

