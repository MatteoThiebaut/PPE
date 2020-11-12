<?php
session_start();

if ($_SESSION['connect'] == true) {
		include_once "../Model/bdd.php";
		$bdd = new Bdd();
		$title = "Liste entrepôt | AllForSport";
		$entrepots = $bdd->getAllEntrepot();
		include_once "../View/depo.php";
		// Liste de tous les entrepôts
    }else{
    	header('Location: ../index.php');
    	exit;
    }
