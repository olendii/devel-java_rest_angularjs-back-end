DROP TABLE IF EXISTS `learner`;
DROP TABLE IF EXISTS `teacher`;
DROP TABLE IF EXISTS `branch`;
DROP TABLE IF EXISTS `user_roles`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE IF NOT EXISTS `users` (
  `user_id`  INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(250)     NOT NULL,
  `login`    VARCHAR(20)      NOT NULL,
  `password` VARCHAR(40)      NOT NULL,
  `email`    VARCHAR(100)              DEFAULT NULL,
  `phone`    VARCHAR(20)               DEFAULT NULL,
  `note`     VARCHAR(250)              DEFAULT NULL,
  `enabled`  TINYINT(4)       NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `name` (`name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id`   INT(11) UNSIGNED NOT NULL,
  `authority` VARCHAR(50)      NOT NULL,
  PRIMARY KEY (`user_id`, `authority`),
  KEY `fk_role_user` (`user_id`),
  CONSTRAINT `fk_role_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `branch` (
  `branch_id` SMALLINT(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`      VARCHAR(250)         NOT NULL,
  `enabled`   TINYINT(4)           NOT NULL DEFAULT '1',
  PRIMARY KEY (`branch_id`),
  UNIQUE KEY `name` (`name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_id` INT(11) UNSIGNED     NOT NULL,
  `branch_id`  SMALLINT(6) UNSIGNED NOT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `fk_teacher_user` (`teacher_id`),
  KEY `fk_teacher_branch` (`branch_id`),
  CONSTRAINT `fk_teacher_branch` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  CONSTRAINT `fk_teacher_user` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`user_id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `learner` (
  `learner_id` INT(11) UNSIGNED     NOT NULL,
  `branch_id`  SMALLINT(6) UNSIGNED NOT NULL,
  PRIMARY KEY (`learner_id`),
  KEY `fk_learner_user` (`learner_id`),
  KEY `fk_learner_branch` (`branch_id`),
  CONSTRAINT `fk_learner_branch` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  CONSTRAINT `fk_learner_user` FOREIGN KEY (`learner_id`) REFERENCES `users` (`user_id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

