<?php
session_start();

if ($_SESSION['connect'] == true) {
	include_once "../Model/bdd.php";
	$bdd = new Bdd();
	$title = "Fiche produits | AllForSport";
	$produit = htmlspecialchars($_GET['id']);
	$produit_détails = $bdd->getDetailsProduits($produit);
	$getAllProduits = $bdd->getProduitsQuant($produit);
	include_once "../View/fiche-produit.php";
	// système permettant d'obtenir l'id, les détails ainsi que la quantité des produits.
} else {
	header('Location: ../index.php');
	exit;
}
