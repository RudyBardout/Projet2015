-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 24 Mars 2016 à 01:57
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `cinema`
--

-- --------------------------------------------------------

--
-- Structure de la table `profile`
--

CREATE TABLE IF NOT EXISTS profile (
  profile_id int NOT NULL AUTO_INCREMENT ,
  password varchar(20) NOT NULL,
  email varchar(20)  NOT NULL,
  eloRank int NOT NULL,
  country varchar(50) NOT NULL,
  username varchar(30) NOT NULL,
  PRIMARY KEY (profile_id)
);

--
-- Contenu de la table `profile`
--

INSERT INTO profile (profile_id,username, country, eloRank, email, password) VALUES
(1, 'Leroy', 'USA', 6, 'leroy@fake.com', 'password1'),
(2, 'Kvothe', 'France', 5, 'kvothe@fake.com', 'password2'),
(3, 'Fitz', 'Angleterre', 1, 'fitz@fake.com', 'password3'),
(4, 'Test', 'France', 3, 'test@fake.com','password4'),
(5, 'Toto', 'France', 2, 'toto@fake.com', 'password5');
(6, 'Zaza', 'France', 4, 'zaza@fake.com', 'password6');


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
