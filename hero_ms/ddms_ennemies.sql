-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 18 déc. 2020 à 11:49
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ddms_ennemies`
--

-- --------------------------------------------------------

--
-- Structure de la table `ennemy`
--

DROP TABLE IF EXISTS `ennemy`;
CREATE TABLE IF NOT EXISTS `ennemy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `health` int(11) NOT NULL,
  `strength` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ennemy`
--

INSERT INTO `ennemy` (`id`, `health`, `strength`, `type`, `number`) VALUES
(1, 15, 4, 'dragon', 4),
(2, 9, 2, 'wizard', 10),
(3, 6, 1, 'goblin', 10);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
