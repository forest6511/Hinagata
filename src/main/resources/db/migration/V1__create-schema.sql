CREATE TABLE roles (
  `id`        BIGINT NOT NULL AUTO_INCREMENT,
  `name`      VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE users (
  `id`        BIGINT NOT NULL AUTO_INCREMENT,
  `first_name`     VARCHAR(128),
  `last_name`      VARCHAR(128),
  `email`          VARCHAR(256),
  `password`       VARCHAR(256),
  `version`    INTEGER,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE INDEX `users_email_UNIQUE` (`email` ASC)
);

CREATE TABLE users_roles (
  `id`        BIGINT NOT NULL AUTO_INCREMENT,
  `user_id`   BIGINT NOT NULL,
  `role_id`   BIGINT NOT NULL,
  PRIMARY KEY (`id`)
);

---------------------------------------
-- tables below is just testing purpose.
---------------------------------------
CREATE TABLE companies (
  `id`        BIGINT NOT NULL AUTO_INCREMENT,
  `name`      VARCHAR(128),
  `zip`       VARCHAR(32),
  `address`   VARCHAR(255),
  `version`   INTEGER,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`)
);

CREATE TABLE departments (
  `id`         BIGINT NOT NULL AUTO_INCREMENT,
  `company_id` BIGINT NOT NULL,
  `name`       VARCHAR(128),
  `version`    INTEGER,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`)
);
