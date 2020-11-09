-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 09 nov. 2020 à 12:57
-- Version du serveur :  8.0.18
-- Version de PHP : 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `stock`
--

-- --------------------------------------------------------

--
-- Structure de la table `batiments`
--

CREATE TABLE `batiments` (
  `ba_id` int(11) NOT NULL,
  `ba_nom` varchar(45) DEFAULT NULL,
  `fk_en` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `batiments`
--

INSERT INTO `batiments` (`ba_id`, `ba_nom`, `fk_en`) VALUES
(1, 'bat1', 1),
(2, 'bat2', 2),
(3, 'bat3', 3),
(4, 'bat4', 3),
(5, 'bat5', 2),
(6, 'bat6', 1);

-- --------------------------------------------------------

--
-- Structure de la table `cellule`
--

CREATE TABLE `cellule` (
  `fk_en` int(11) NOT NULL,
  `fk_ba` int(11) NOT NULL,
  `fk_mo` char(2) NOT NULL,
  `fk_ra` char(1) NOT NULL,
  `fk_se` char(2) NOT NULL,
  `fk_et` char(1) NOT NULL,
  `ce_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cellule`
--

INSERT INTO `cellule` (`fk_en`, `fk_ba`, `fk_mo`, `fk_ra`, `fk_se`, `fk_et`, `ce_id`) VALUES
(1, 1, 'M1', 'A', '1', '1', 1),
(1, 6, 'M2', 'B', '12', '8', 2),
(2, 2, 'M3', 'C', '3', '4', 3),
(2, 5, 'M4', 'F', '8', '2', 4),
(3, 3, 'M5', 'J', '10', '6', 5),
(3, 4, 'M6', 'L', '5', '3', 6);

-- --------------------------------------------------------

--
-- Structure de la table `comprend`
--

CREATE TABLE `comprend` (
  `fk_pr` int(11) NOT NULL,
  `fk_ce` int(11) NOT NULL,
  `fk_en` int(11) NOT NULL,
  `fk_ba` int(11) NOT NULL,
  `fk_mo` char(2) NOT NULL,
  `fk_ra` char(1) NOT NULL,
  `fk_se` char(2) NOT NULL,
  `fk_et` char(1) NOT NULL,
  `quantité` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `comprend`
--

INSERT INTO `comprend` (`fk_pr`, `fk_ce`, `fk_en`, `fk_ba`, `fk_mo`, `fk_ra`, `fk_se`, `fk_et`, `quantité`) VALUES
(1, 1, 1, 1, 'M1', 'A', '1', '1', 25),
(1, 2, 1, 6, 'M2', 'B', '12', '8', 25),
(3, 5, 3, 3, 'M5', 'J', '10', '6', 100),
(3, 6, 3, 4, 'M6', 'L', '5', '3', 300),
(5, 3, 2, 2, 'M3', 'C', '3', '4', 3),
(8, 4, 2, 5, 'M4', 'F', '8', '2', 4);

-- --------------------------------------------------------

--
-- Structure de la table `entrepots`
--

CREATE TABLE `entrepots` (
  `en_id` int(11) NOT NULL,
  `en_nom` varchar(45) DEFAULT NULL,
  `en_localisation` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `entrepots`
--

INSERT INTO `entrepots` (`en_id`, `en_nom`, `en_localisation`) VALUES
(1, 'A', 'Havre'),
(2, 'B', 'Marseille'),
(3, 'C', 'Lyon');

-- --------------------------------------------------------

--
-- Structure de la table `etage`
--

CREATE TABLE `etage` (
  `fk_en` int(11) NOT NULL,
  `fk_ba` int(11) NOT NULL,
  `fk_mo` char(2) NOT NULL,
  `fk_ra` char(1) NOT NULL,
  `fk_se` char(2) NOT NULL,
  `et_id` char(1) NOT NULL,
  `et_nom` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etage`
--

INSERT INTO `etage` (`fk_en`, `fk_ba`, `fk_mo`, `fk_ra`, `fk_se`, `et_id`, `et_nom`) VALUES
(1, 1, 'M1', 'A', '1', '1', 'etage1'),
(1, 6, 'M2', 'B', '12', '8', 'etage8'),
(2, 2, 'M3', 'C', '3', '4', 'etage4'),
(2, 5, 'M4', 'F', '8', '2', 'etage2'),
(3, 3, 'M5', 'J', '10', '6', 'etage6'),
(3, 4, 'M6', 'L', '5', '3', 'etage3');

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `fk_me` varchar(255) NOT NULL,
  `lo_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

CREATE TABLE `membre` (
  `me_id` varchar(255) NOT NULL,
  `me_nom` varchar(45) NOT NULL,
  `me_prenom` varchar(45) NOT NULL,
  `me_email` varchar(255) NOT NULL,
  `me_sex` int(11) NOT NULL,
  `me_rang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `mo_id` char(2) NOT NULL,
  `mo_nom` varchar(45) DEFAULT NULL,
  `fk_en` int(11) NOT NULL,
  `fk_ba` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`mo_id`, `mo_nom`, `fk_en`, `fk_ba`) VALUES
('M1', 'module1', 1, 1),
('M2', 'module2', 1, 6),
('M3', 'module3', 2, 2),
('M4', 'module4', 2, 5),
('M5', 'module5', 3, 3),
('M6', 'module6', 3, 4);

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE `produits` (
  `pr_id` int(11) NOT NULL,
  `pr_nom` varchar(45) DEFAULT NULL,
  `pr_referece` varchar(45) DEFAULT NULL,
  `pr_nomFournisseur` varchar(45) DEFAULT NULL,
  `pr_cout` int(11) DEFAULT NULL,
  `pr_unitaire` int(11) DEFAULT NULL,
  `pr_description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`pr_id`, `pr_nom`, `pr_referece`, `pr_nomFournisseur`, `pr_cout`, `pr_unitaire`, `pr_description`) VALUES
(1, 'table', 'eisten', 'majuscule', 5, 1, 'aa'),
(2, 'chaise', 'bigard', 'majuscule', 2, 2, 'zz'),
(3, 'crayon', 'hollande', 'majuscule', 51, 3, 'ee'),
(4, 'stylo', 'sarkozy', 'majuscule', 9, 4, 'rr'),
(5, 'gomme', 'trump', 'majuscule', 532, 5, 'tt'),
(6, 'marine lepen', 'merkel', 'jean marie lepen', 83, 6, 'yy'),
(7, 'prise', 'cateloup', 'edf', 9, 7, 'uu'),
(8, 'chargeur', 'cyprien', 'edf', 754, 8, 'ii'),
(9, 'souris', 'anouna', 'chat', 26526, 9, 'oo'),
(10, 'clavier', 'krykawsky', 'raser', 46, 10, 'pp'),
(11, 'ciseaux', 'cesar', 'salut', 359, 11, 'mm'),
(12, 'webcam', 'legropierre', 'cocofr', 26, 12, 'll'),
(13, 'croustibate', 'cryspi', 'findus', 45, 13, 'nn');

-- --------------------------------------------------------

--
-- Structure de la table `ranger`
--

CREATE TABLE `ranger` (
  `fk_en` int(11) NOT NULL,
  `fk_ba` int(11) NOT NULL,
  `fk_mo` char(2) NOT NULL,
  `ra_id` char(1) NOT NULL,
  `ra_nom` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ranger`
--

INSERT INTO `ranger` (`fk_en`, `fk_ba`, `fk_mo`, `ra_id`, `ra_nom`) VALUES
(1, 1, 'M1', 'A', 'droite'),
(1, 6, 'M2', 'B', 'droite'),
(2, 2, 'M3', 'C', 'droite'),
(2, 5, 'M4', 'F', 'droite'),
(3, 3, 'M5', 'J', 'gauche'),
(3, 4, 'M6', 'L', 'gauche');

-- --------------------------------------------------------

--
-- Structure de la table `section`
--

CREATE TABLE `section` (
  `fk_en` int(11) NOT NULL,
  `fk_ba` int(11) NOT NULL,
  `fk_mo` char(2) NOT NULL,
  `fk_ra` char(1) NOT NULL,
  `se_id` char(2) NOT NULL,
  `se_nom` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `section`
--

INSERT INTO `section` (`fk_en`, `fk_ba`, `fk_mo`, `fk_ra`, `se_id`, `se_nom`) VALUES
(1, 1, 'M1', 'A', '1', 'section1'),
(1, 6, 'M2', 'B', '12', 'section12'),
(2, 2, 'M3', 'C', '3', 'section3'),
(2, 5, 'M4', 'F', '8', 'section8'),
(3, 3, 'M5', 'J', '10', 'section10'),
(3, 4, 'M6', 'L', '5', 'section5');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `batiments`
--
ALTER TABLE `batiments`
  ADD PRIMARY KEY (`ba_id`,`fk_en`),
  ADD KEY `fk_en_idx` (`fk_en`);

--
-- Index pour la table `cellule`
--
ALTER TABLE `cellule`
  ADD PRIMARY KEY (`ce_id`,`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`,`fk_se`,`fk_et`),
  ADD KEY `fk_et_idx` (`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`,`fk_se`,`fk_et`);

--
-- Index pour la table `comprend`
--
ALTER TABLE `comprend`
  ADD PRIMARY KEY (`fk_pr`,`fk_ce`,`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`,`fk_se`,`fk_et`),
  ADD KEY `fk_pr_idx` (`fk_pr`),
  ADD KEY `fk_ce_idx` (`fk_ce`,`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`,`fk_se`,`fk_et`);

--
-- Index pour la table `entrepots`
--
ALTER TABLE `entrepots`
  ADD PRIMARY KEY (`en_id`);

--
-- Index pour la table `etage`
--
ALTER TABLE `etage`
  ADD PRIMARY KEY (`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`,`fk_se`,`et_id`);

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`fk_me`);

--
-- Index pour la table `membre`
--
ALTER TABLE `membre`
  ADD PRIMARY KEY (`me_id`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`mo_id`,`fk_ba`,`fk_en`),
  ADD KEY `fk_ba_idx` (`fk_en`,`fk_ba`);

--
-- Index pour la table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`pr_id`);

--
-- Index pour la table `ranger`
--
ALTER TABLE `ranger`
  ADD PRIMARY KEY (`fk_en`,`fk_ba`,`fk_mo`,`ra_id`),
  ADD KEY `fk_mo_idx` (`fk_en`,`fk_ba`,`fk_mo`);

--
-- Index pour la table `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`,`se_id`),
  ADD KEY `fk_ra_idx` (`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `batiments`
--
ALTER TABLE `batiments`
  MODIFY `ba_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `entrepots`
--
ALTER TABLE `entrepots`
  MODIFY `en_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `produits`
--
ALTER TABLE `produits`
  MODIFY `pr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `batiments`
--
ALTER TABLE `batiments`
  ADD CONSTRAINT `fk_en` FOREIGN KEY (`fk_en`) REFERENCES `entrepots` (`en_id`);

--
-- Contraintes pour la table `cellule`
--
ALTER TABLE `cellule`
  ADD CONSTRAINT `fk_et` FOREIGN KEY (`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`,`fk_se`,`fk_et`) REFERENCES `etage` (`fk_en`, `fk_ba`, `fk_mo`, `fk_ra`, `fk_se`, `et_id`);

--
-- Contraintes pour la table `comprend`
--
ALTER TABLE `comprend`
  ADD CONSTRAINT `fk_ce` FOREIGN KEY (`fk_ce`,`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`,`fk_se`,`fk_et`) REFERENCES `cellule` (`ce_id`, `fk_en`, `fk_ba`, `fk_mo`, `fk_ra`, `fk_se`, `fk_et`),
  ADD CONSTRAINT `fk_pr` FOREIGN KEY (`fk_pr`) REFERENCES `produits` (`pr_id`);

--
-- Contraintes pour la table `etage`
--
ALTER TABLE `etage`
  ADD CONSTRAINT `fk_se` FOREIGN KEY (`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`,`fk_se`) REFERENCES `section` (`fk_en`, `fk_ba`, `fk_mo`, `fk_ra`, `se_id`);

--
-- Contraintes pour la table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `fk_me` FOREIGN KEY (`fk_me`) REFERENCES `membre` (`me_id`);

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `fk_ba` FOREIGN KEY (`fk_en`,`fk_ba`) REFERENCES `batiments` (`fk_en`, `ba_id`);

--
-- Contraintes pour la table `ranger`
--
ALTER TABLE `ranger`
  ADD CONSTRAINT `fk_mo` FOREIGN KEY (`fk_en`,`fk_ba`,`fk_mo`) REFERENCES `module` (`fk_en`, `fk_ba`, `mo_id`);

--
-- Contraintes pour la table `section`
--
ALTER TABLE `section`
  ADD CONSTRAINT `fk_ra` FOREIGN KEY (`fk_en`,`fk_ba`,`fk_mo`,`fk_ra`) REFERENCES `ranger` (`fk_en`, `fk_ba`, `fk_mo`, `ra_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
