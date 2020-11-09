<?php
session_start();

if ($_SESSION['connect'] == true) {
		include_once "../Model/bdd.php";
		$bdd = new Bdd();
		$title = "Liste des produits | AllForSport";
		$entrepot = htmlspecialchars($_GET['id']);
		$produits = $bdd->getAllProduits($entrepot);
		include_once "../View/produit.php";
    }else{
    	header('Location: ../index.php');
    	exit;
    }
?>
