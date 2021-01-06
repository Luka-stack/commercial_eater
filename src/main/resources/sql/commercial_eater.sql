DROP TABLE IF EXISTS `cities`;

CREATE TABLE IF NOT EXISTS `cities` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `cities` (`name` ASC);

------------------------------------------------------------------

DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `city` INT NOT NULL,
  `balance` DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `email_UNIQUE` ON `users` (`email` ASC);

------------------------------------------------------------------

DROP TABLE IF EXISTS `restaurants`;

CREATE TABLE IF NOT EXISTS `restaurants` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(255),
    `address` VARCHAR(45),
    PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `restaurants` (`name` ASC);

------------------------------------------------------------------

DROP TABLE IF EXISTS `dishes`;

CREATE TABLE IF NOT EXISTS `dishes` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(255),
    `dishType` VARCHAR(20) NOT NULL,
    `diet` VARCHAR(20) NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    `restaurantId` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_dish_restaurant`
        FOREIGN KEY (`restaurantId`)
        REFERENCES `restaurants` (`id`)
        ON DELETE CASCADE
        ON UPDATE NO ACTION)
ENGINE = InnoDB;

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
