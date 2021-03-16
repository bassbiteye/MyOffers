-- Adminer 4.7.6 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `candidat`;
CREATE TABLE `candidat` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `nom` varchar(255) DEFAULT NULL,
                            `prenom` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `candidat` (`id`, `nom`, `prenom`) VALUES
(1,	'Biteye',	'Bassirou'),
(2,	'thiam',	'abdou');

DROP TABLE IF EXISTS `offre_user`;
CREATE TABLE `offre_user` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `id_candidat` int NOT NULL,
                              `id_offre` int NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `id_candidat` (`id_candidat`),
                              KEY `id_offre` (`id_offre`),
                              CONSTRAINT `offre_user_ibfk_1` FOREIGN KEY (`id_candidat`) REFERENCES `candidat` (`id`),
                              CONSTRAINT `offre_user_ibfk_2` FOREIGN KEY (`id_offre`) REFERENCES `offres` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `offre_user` (`id`, `id_candidat`, `id_offre`) VALUES
(4,	1,	9),
(6,	1,	1),
(7,	2,	1),
(8,	2,	2);

DROP TABLE IF EXISTS `offres`;
CREATE TABLE `offres` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `titre` varchar(255) NOT NULL,
                          `description` text NOT NULL,
                          `date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          `vue` int DEFAULT NULL,
                          `type` varchar(255) DEFAULT NULL,
                          `ville` varchar(255) DEFAULT NULL,
                          `entreprise` int DEFAULT NULL,
                          `publier` int DEFAULT NULL,
                          `secteur` int DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `offres` (`id`, `titre`, `description`, `date`, `vue`, `type`, `ville`, `entreprise`, `publier`, `secteur`) VALUES
(1,	'developpeur web',	'nous cherchons un developpeur web avec une année d\'expérience',	'2021-03-01 11:12:18',	NULL,	'cdd',	'dakar',	NULL,	NULL,	NULL),
(2,	'community management',	'community management',	'2021-03-01 11:12:55',	NULL,	'cdd',	'dakar',	NULL,	NULL,	NULL),
(9,	'css',	'ssc',	'2021-03-01 15:00:01',	NULL,	'cssc',	'sscs',	NULL,	NULL,	NULL),
(10,	'sxsx',	'sxsxs',	'2021-03-01 15:00:57',	NULL,	'xsxsxsx',	'sxsxsx',	NULL,	NULL,	NULL),
(11,	'sxsxs',	'sxsxsx',	'2021-03-01 15:01:21',	NULL,	'sxsx',	'sxsxsx',	NULL,	NULL,	NULL),
(12,	'dvd',	'hgyj',	'2021-03-01 15:03:31',	NULL,	'vvbbn',	'bfh',	NULL,	NULL,	NULL),
(13,	'iuy',	'lkjh',	'2021-03-01 15:11:26',	NULL,	'lkj',	'lkj',	NULL,	NULL,	NULL),
(14,	'test',	'test',	'2021-03-02 23:12:57',	NULL,	'fatick',	'stage',	NULL,	NULL,	NULL);

DROP TABLE IF EXISTS `recruter`;
CREATE TABLE `recruter` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_offre` int NOT NULL,
  `id_candidat` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_offre` (`id_offre`),
  KEY `id_candidat` (`id_candidat`),
  CONSTRAINT `recruter_ibfk_1` FOREIGN KEY (`id_offre`) REFERENCES `offres` (`id`),
  CONSTRAINT `recruter_ibfk_2` FOREIGN KEY (`id_candidat`) REFERENCES `candidat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `recruter` (`id`, `id_offre`, `id_candidat`) VALUES
(1,	1,	1);

DROP TABLE IF EXISTS `rv`;
CREATE TABLE `rv` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_offre` int NOT NULL,
  `id_candidat` int NOT NULL,
  `date` date DEFAULT NULL,
  `heure` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_offre` (`id_offre`),
  KEY `id_candidat` (`id_candidat`),
  CONSTRAINT `rv_ibfk_1` FOREIGN KEY (`id_offre`) REFERENCES `offres` (`id`),
  CONSTRAINT `rv_ibfk_2` FOREIGN KEY (`id_candidat`) REFERENCES `candidat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `rv` (`id`, `id_offre`, `id_candidat`, `date`, `heure`) VALUES
(1,	1,	1,	'2020-12-12',	'14:14:00'),
(3,	1,	2,	'2020-02-02',	'12:16:00');

DROP TABLE IF EXISTS `selectionner`;
CREATE TABLE `selectionner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_offre` int NOT NULL,
  `id_candidat` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_offre` (`id_offre`),
  KEY `id_candidat` (`id_candidat`),
  CONSTRAINT `selectionner_ibfk_1` FOREIGN KEY (`id_offre`) REFERENCES `offres` (`id`),
  CONSTRAINT `selectionner_ibfk_2` FOREIGN KEY (`id_candidat`) REFERENCES `candidat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `selectionner` (`id`, `id_offre`, `id_candidat`) VALUES
(1,	9,	1),
(2,	9,	2),
(3,	1,	1);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user` (`id`, `nom`, `prenom`, `role`) VALUES
(1,	'Biteye',	'Bassirou',	'admin'),
(2,	'thiam',	'moussa',	'admin');

-- 2021-03-16 14:41:45
