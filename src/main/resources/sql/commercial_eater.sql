DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `balance` DECIMAL NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `email_UNIQUE` ON `users` (`email` ASC);

------------------------------------------------------------------

DROP TABLE IF EXISTS `restaurants`;

CREATE TABLE IF NOT EXISTS `restaurants` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(50),
    `address` VARCHAR(45),
    PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `restaurants` (`name` ASC);

------------------------------------------------------------------

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE IF NOT EXISTS `transactions` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `dateTime` DATE NOT NULL,
    `transactionType` ENUM('TOP_UP','ORDER') NOT NULL,
    `amount` DECIMAL NOT NULL,
    `userId` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_transactions_users`
        FOREIGN KEY (`userId`)
        REFERENCES `users` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_transactions_users_idx` ON `transactions` (`userId` ASC);

